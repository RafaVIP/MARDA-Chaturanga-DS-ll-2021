
/**
 ** Primera iteración Proyecto Programado: Diseño Rafael Porras (B75915) Fabian
 * Gonzalez (B83493) Kevin Salas (B87161) Wendy Ortiz (B75594)
 **/

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Chaturanga extends PartidaAbstracta {
  /*----------------- Propios de Chaturanga------------------*/
  InterfazGraficaGenerica interfaz;
  PiezaAbstracta piezaSeleccionada;
  ArrayList<String> movimientos;
  int xPiezaSeleccionada, yPiezaSeleccionada;

  /// Contructor
  public Chaturanga() {
    this.TOTAL_JUGADORES = 2;
    this.interfaz = new InterfazGraficaGenerica("Chaturanga", this);
  }

  /**
   * Metodo de clase abstracta encargado de cargar la partida
   * 
   * @param filepath recibe un string con un path
   * @return un objeto de toipo PartidaAbstracta
   */
  public void cargarPartida(String filepath) {
    FileManagerChaturanga manager = new FileManagerChaturanga();
    if (filepath.equals("src/inicio.txt")) {
      this.jugadores = new JugadorChaturanga[this.TOTAL_JUGADORES];
      this.jugadorActual = 0;
      asignarColores();
    } else {
      this.jugadores = manager.cargarJugadores(filepath);
      this.jugadorActual = manager.cargarJugadorActual(filepath);
    }
    this.tablero = manager.cargarTablero(filepath);
    setElementosDeInterfazIniciales(interfaz);
    imprimirTablero();
  }

  /**
   * Metodo encargado de imprimir el tablero
   */
  public void imprimirTablero() {
    /**
     * Recibe: {Casilla, Casilla, ...} Casilla = {Pieza, Casilla} o {Casilla} Pieza
     * / Casilla = {filepath, ejeX, ejeY}
     */
    ArrayList<ArrayList<ArrayList<String>>> tablero = this.tablero.imprimirTablero();
    for (int casilla = 0; casilla < tablero.size(); casilla++) {
      for (int contenidoDeCasilla = 0; contenidoDeCasilla < tablero.get(casilla).size(); contenidoDeCasilla++) {
        interfaz.printImage(tablero.get(casilla).get(contenidoDeCasilla).get(0),
            /** Filepath de imagen (casilla o pieza) */
            Integer.parseInt(tablero.get(casilla).get(contenidoDeCasilla).get(1)),
            /** Eje X donde tiene que imprimirse */
            Integer.parseInt(tablero.get(casilla).get(contenidoDeCasilla).get(2)));
        /** Eje Y donde tiene que imprimirse */
      }
    }
  }

  /**
   * Metodo encargado de asignar los colores
   */
  public void asignarColores() {
    ArrayList<String> colores = new ArrayList<String>();
    colores.add("blanco");
    colores.add("rojo");
    for (int i = 0; i < jugadores.length; i++) {
      this.jugadores[i] = new JugadorChaturanga(colores);
      String colorElegido = this.jugadores[i].getColor();
      for (int iterador = 0; iterador < colores.size(); iterador++) {
        if (colores.get(iterador) == colorElegido) {
          /// permite que el jugador no escoja un color repetido
          colores.remove(iterador);
          iterador = colores.size();
        }
      }
    }
  }

  /**
   * Metodo encargado de mostrar y configurar elementos en la interfaz
   * 
   * @param interfaz
   */
  public void setElementosDeInterfazIniciales(InterfazGraficaGenerica interfaz) {
    addButtonReglas(interfaz);
    addButtonGuardarPartida(interfaz);
    addButtonJugadores(interfaz);
    addButtonPiezasPerdidas(interfaz);
  }

  /**
   * Metodo encargado de añadir el botton de las reglas en la interfaz
   * 
   * @param interfaz
   */
  public void addButtonReglas(InterfazGraficaGenerica interfaz) {
    /** Agrega el boton de las reglas en la interfaz del juego */
    ActionListener rules = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        FileManagerDePartidasAbstracto fileManager = new FileManagerChaturanga();
        String content = fileManager.readFile("src/rules.txt");
        interfaz.mostrarCuadroDialogo(null, content); // Jalar contenido de txt de las reglas
      }
    };
    interfaz.agregarBoton("Reglas", rules, 0, 0);
  }

  /**
   * Metodo encargado de añadir el buton de guardar partida
   * 
   * @param interfaz
   */
  public void addButtonGuardarPartida(InterfazGraficaGenerica interfaz) {
    /** Guardar Partida */
    ActionListener guardarPartida = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        guardarPartida();
      }
    };
    interfaz.agregarBoton("Guardar", guardarPartida, 102, 0);
  }

  /**
   * Metodo encargado de añadir el boton de jugadores a la interfaz
   * 
   * @param interfaz
   */
  public void addButtonJugadores(InterfazGraficaGenerica interfaz) {
    /** Color de los jugadores */
    String datos = "";
    for (int i = 0; i < this.jugadores.length; i++) {
      datos += jugadores[i].getNombre() + ": Juega con " + jugadores[i].getColor() + "\n";
    }
    final String datos2 = datos;
    ActionListener players = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        interfaz.mostrarCuadroDialogo(null, datos2);
      }
    };
    interfaz.agregarBoton("Jugadores", players, 204, 0);
  }

  /**
   * Metodo encargado de añadir el boton de las piezas perdidas a la interfaz
   * 
   * @param interfaz
   */
  public String piezasPerdidas() {
    /** Piezas perdidas */
    String perdidas = "";
    for (int i = 0; i < this.jugadores.length; i++) {
      ArrayList<PiezaAbstracta> arrayPiezasPerdidas = jugadores[i].getArrayPerdidos();
      perdidas += "\n" + jugadores[i].getNombre() + ": Juega con " + jugadores[i].getColor() + "";
      if (arrayPiezasPerdidas.size() == 0) {
        perdidas += "\n   No tiene piezas perdidas \n";
      } else {
        perdidas += "\n   Este jugador tiene las siguientes piezas perdidas: \n";
        for (int j = 0; j < arrayPiezasPerdidas.size(); j++) {
          if (arrayPiezasPerdidas.size() > 0) {
            perdidas += "   " + arrayPiezasPerdidas.get(j).getNombre() + "\n";
          }
        }

      }
    }
    return perdidas;
  }

  public void addButtonPiezasPerdidas(InterfazGraficaGenerica interfaz) {

    ActionListener piezasPerdidas = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        interfaz.mostrarCuadroDialogo(null, piezasPerdidas());
      }
    };
    interfaz.agregarBoton("P.perdidas", piezasPerdidas, 306, 0);
  }
  /*----------------- De Partida Abstracta---------------------*/

  /**
   * Metodo encargado de Iniciar una partida
   **/
  public void iniciarPartida() {
    /*
     * int jugadorActual = 0; int [2] coordenadas elegidas;
     * while(!elJuegoHaTerminado()){ coordenadasElegidas =
     * jugador.solicitarCasillaAMoverse(); // Check si la casilla elegida es valida
     * if (tablero[x_actual][y_actual].movimiento(x_actual, y_actual, x_solicitado,
     * y_solicitado)) { tablero[x_solicitado][y_solicitado] =
     * tablero[x_actual][y_actual].getContenido();
     * tablero[x_actual][y_actual].setCasillaVacia(); } else {
     * 
     * } }
     */
  }

  /**
   * Metodo encargado de guardar una partida en un .txt
   * 
   * @return true si guarda correctamente
   */
  public boolean guardarPartida() {
    FileManagerDePartidasAbstracto fileManager = new FileManagerChaturanga();
    return fileManager.guardarPartida(this);
  }

  /**
   * Metodo encargado de verificar que el juego haya terminado
   * 
   * @return True si el juego a terminado
   */
  public boolean elJuegoHaTerminado() {
    return false;
  }

  /**
   * Metodo encargado de convertir a un string
   * 
   * @return String
   */
  public String to_String() {
    String chaturanga = "";
    // Jugador actual
    chaturanga += this.jugadorActual + "\n";
    // Tablero
    chaturanga += this.tablero.toString();
    // Jugadores
    for (int jugador = 0; jugador < this.TOTAL_JUGADORES; jugador++) {
      chaturanga += this.jugadores[jugador].to_String();
    }
    return chaturanga;
  }

  // Esta matriz basicamente marca todos los lugares donde
  // se pueden atacar las piezas enemigas. Se usa para revisar
  // que jugadas son validas.
  // Safe = "" ||
  public ArrayList<String> crearJacqueMatriz(Casilla[][] tablero) {
    ArrayList<String> jacque_matriz = new ArrayList<String>();
    Casilla[][] tablero_copia = tablero;
    String my_color = (this.jugadorActual % 2 == 0) ? "blanco" : "rojo";
    // Inicializo la matriz con "" que significa que es casilla segura
    for (int x = 0; x < 8; ++x) {
      for (int y = 0; y < 8; ++y) {
        jacque_matriz.add("vacio");
      }
    }
    // Recorro el tablero buscando los movimientos de posibles de mi color
    for (int x = 0; x < 8; ++x) {
      for (int y = 0; y < 8; ++y) {
        if (tablero_copia[x][y].contenido != null) {
          if (tablero_copia[x][y].getColor().equals(my_color) == false) {
            ArrayList<String> movimientos = tablero_copia[x][y].contenido.getPosiblesMovimientos(tablero_copia, x, y);
            // Los lugares donde puedo mover mis piezas son zonas de peligro o "jaque"
            for (int current_mov = 0; current_mov < movimientos.size(); ++current_mov) {
              String movimiento = movimientos.get(current_mov);
              int mov_x = movimiento.charAt(1) - 48;
              int mov_y = movimiento.charAt(4) - 48;
              jacque_matriz.set((8 * mov_x) + mov_y, "jaque");
            }
          }
        }
      }
    }
    return jacque_matriz;
  }

  public Casilla[][] copiarTablero(Casilla[][] tablero) {
    Casilla[][] nuevo_tablero = new Casilla[8][8];
    FileManagerChaturanga creadorDePiezas = new FileManagerChaturanga();
    for (int x = 0; x < 8; ++x) {
      for (int y = 0; y < 8; ++y) {
        nuevo_tablero[x][y] = new Casilla(x, y);
        if (tablero[x][y].contenido != null) {
          PiezaAbstracta pieza = creadorDePiezas.crearPiezaAbstracta(tablero[x][y].getNombre(),
              tablero[x][y].getColor());
          nuevo_tablero[x][y].setContenido(pieza);
        } else {
          PiezaAbstracta pieza = null;
          nuevo_tablero[x][y].setContenido(pieza);
        }
      }
    }
    return nuevo_tablero;
  }

  // Remueve movimientos que ponen en peligro al rey
  public ArrayList<String> filtrarMovimientos(ArrayList<String> movimientos) {
    String my_color = (this.jugadorActual % 2 == 0) ? "blanco" : "rojo";
    // Remover movimientos de piezas rojas, si es turno blanco y viceversa
    if (movimientos.size() > 0) {
      if (this.tablero.tablero[xPiezaSeleccionada][yPiezaSeleccionada].getColor().equals(my_color) == false) {
        int mov_len = movimientos.size() - 1;
        for (int i = mov_len; i >= 0; --i) {
          movimientos.remove(i);
        }
      }
    }
    int total_moves = movimientos.size() - 1;
    for (int current_mov = total_moves; current_mov >= 0; --current_mov) {
      Casilla[][] tablero_temporal = copiarTablero(this.tablero.tablero);
      // Hacer la jugada en el tablero temporal
      String movimiento = movimientos.get(current_mov);
      int a = movimiento.charAt(1) - 48;
      int b = movimiento.charAt(4) - 48;
      tablero_temporal[a][b].setContenido(piezaSeleccionada);
      tablero_temporal[this.xPiezaSeleccionada][this.yPiezaSeleccionada].setCasillaVacia();
      // Actualizar la jacque matriz temporal
      ArrayList<String> jacque_matriz = crearJacqueMatriz(tablero_temporal);
      // Revisar si el rey se encuentra en Jaque en la jacque matriz temporal
      for (int x = 0; x < 8; ++x) {
        for (int y = 0; y < 8; ++y) {
          String estado = jacque_matriz.get((8 * x) + y);
          if (estado.equals("jaque")) {
            if (tablero_temporal[x][y].contenido != null) {
              if (tablero_temporal[x][y].contenido.getColor().equals(my_color)) {
                if (tablero_temporal[x][y].contenido.getNombre().equals("Rey")) {
                  movimientos.remove(current_mov);
                }
              }
            }
          }
        }
      }
    }
    return movimientos;
  }

  /**
   * Metodo encargado de enviar las coordenadas para los action listener del mouse
   * 
   * @param cordX
   * @param cordy
   */
  public void enviarCoordenadasMouse(int cordX, int cordy) {
    cordX = (cordX - 5) / 75;
    cordy = (cordy - 25) / 75;
    if (cordX < 8 && cordy < 8) {
      // Si no ha seleccionado pieza
      if (piezaSeleccionada == null) {
        // Si la casilla seleccionada tiene una ficha
        if (tablero.tablero[cordX][cordy].contenido != null) {
          // Setea la pieza seleccionada
          this.piezaSeleccionada = tablero.tablero[cordX][cordy].getContenido();
          this.xPiezaSeleccionada = cordX;
          this.yPiezaSeleccionada = cordy;
          // Toma los posibles movimientos
          this.movimientos = tablero.tablero[cordX][cordy].contenido.getPosiblesMovimientos(tablero.tablero, cordX,
              cordy);
          // Remueve los movimientos que exponen al rey
          this.movimientos = filtrarMovimientos(movimientos);
          // pinta las casillas
          this.pintarCasillas(this.movimientos);
          this.interfaz.pintarCasillaSeleccionada(cordy, cordX);
        } else {
          System.out.println("Casilla vacia\n");
        }
      } else { // Si ya selecciono pieza
        // Chequea los posibles movimientos
        for (int posibleMovimiento = 0; posibleMovimiento < this.movimientos.size(); posibleMovimiento++) {
          String movimiento = movimientos.get(posibleMovimiento);
          int a = movimiento.charAt(1) - 48;
          int b = movimiento.charAt(4) - 48;
          // Verificar si la casilla elegida esta dentro de los posibles movimientos
          if (a == cordX && b == cordy) {
            // Si hay una pieza enemiga
            if (this.tablero.tablero[cordX][cordy].getContenido() != null && !this.tablero.tablero[cordX][cordy]
                .getContenido().getColor().equals(this.piezaSeleccionada.getColor())) {
              for (int i = 0; i < this.jugadores.length; i++) {
                if (jugadores[i].getColor().equals(this.tablero.tablero[cordX][cordy].getContenido().getColor())) {
                  jugadores[i].setArrayPerdidos(this.tablero.tablero[cordX][cordy].getContenido());
                }
              }
            }
            // Pone la pieza nueva
            this.interfaz.printImage(this.piezaSeleccionada.getImageFilePath(), cordX, cordy);
            this.tablero.tablero[cordX][cordy].setContenido(this.piezaSeleccionada);
            // Borra la pieza de la posicion anterior seleccionada
            this.interfaz.borrarIcon(this.yPiezaSeleccionada, this.xPiezaSeleccionada);
            this.tablero.tablero[this.xPiezaSeleccionada][this.yPiezaSeleccionada].setCasillaVacia();
            // Se formaliza el turno
            ++this.jugadorActual;
            System.out.println("Turno actual: " + (jugadorActual % 2 == 0 ? "blanco" : "rojo"));
            // Termina el ciclo
            posibleMovimiento = this.movimientos.size();
          }
        }
        // Deselecciona movimientos y pieza seleccionada
        this.piezaSeleccionada = null;
        this.interfaz.borraMovimiento(this.yPiezaSeleccionada, this.xPiezaSeleccionada);
        limpiarCasillas(this.movimientos);
      }
    } else {
      // Deselecciona movimientos y pieza seleccionada
      this.piezaSeleccionada = null;
      this.interfaz.borraMovimiento(this.yPiezaSeleccionada, this.xPiezaSeleccionada);
      limpiarCasillas(this.movimientos);
      System.out.println("Fuera de rango");
    }
  }

  /**
   * Metodo encargado de pintar las casillas con los movimientos
   * 
   * @param movimientos
   */
  public void pintarCasillas(ArrayList<String> movimientos) {
    // pinta los posibles movimientos
    for (int i = 0; i < movimientos.size(); i++) {
      String movimiento = movimientos.get(i);
      int a = movimiento.charAt(1) - 48;
      int b = movimiento.charAt(4) - 48;
      this.interfaz.pintarmovimiento(b, a);
    }
  }

  /**
   * Metodo encargado de limpiar las casillas del tablero
   * 
   * @param movimientos
   */
  public void limpiarCasillas(ArrayList<String> movimientos) {
    // limpia las casillas
    for (int i = 0; i < movimientos.size(); i++) {
      String movimiento = movimientos.get(i);
      int a = movimiento.charAt(1) - 48;
      int b = movimiento.charAt(4) - 48;
      this.interfaz.borraMovimiento(b, a);
    }
  }

  /**
   * Metodo encargado de seleccionar el filepath del usuario
   * 
   * @param filepath la ubicación del archivo
   */
  public String seleccionarPartida(String filepath) {
    ArrayList<String> content = new ArrayList<String>();
    String line = "";
    try {
      BufferedReader bf = new BufferedReader(new FileReader(filepath));
      while ((line = bf.readLine()) != null) {
        String tmp_content = line;
        content.add(tmp_content);
      }
      bf.close();
      String actual_content[] = new String[content.size()];
      for (int index = 0; index < actual_content.length; index++) {
        actual_content[index] = content.get(index);
      }
      int opcion = JOptionPane.showOptionDialog(null, "Elige la partida a guardar", "Elige...", 0,
          JOptionPane.QUESTION_MESSAGE, null, actual_content, actual_content[0]);
      filepath = actual_content[opcion];
    } catch (Exception e) {
      System.out.println(e);
      System.out.println("Error en lectura del archivo");
    }
    return filepath;
  }

  /**
   * Metodo encargado de mostrat el menu en pantalla para la seleccion de las
   * partidas
   * 
   * @return opcion que el usuario seleciono
   */
  public int seleccionar_menu() {
    String[] opciones = { "Nueva Partida", "Cargar Partida" };

    int opcion = JOptionPane.showOptionDialog(null, "Elige la forma en la que desea jugar", "Elige...", 0,
        JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

    return opcion;
  }
}
