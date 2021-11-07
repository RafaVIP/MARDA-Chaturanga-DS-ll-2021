
/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161)
 ** Wendy Ortiz (B75594)
 **/

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Chaturanga extends PartidaAbstracta {
  /*----------------- Propios de Chaturanga------------------*/
  InterfazGraficaGenerica interfaz;

  /// Contructor
  public Chaturanga() {
    this.TOTAL_JUGADORES = 4;
    this.jugadores = new JugadorChaturanga[this.TOTAL_JUGADORES];
    this.jugadorActual = 0;
    asignarColores();

    // Tablero
    int filas = 8;
    int columnas = 8;
    this.interfaz = new InterfazGraficaGenerica("Chaturanga");
    // TODO: for 2nd sprind: especificar el path para cuando se carga partida
    this.tablero = new Tablero("src/inicio.txt", filas, columnas);
    setEstadoInicialDeLasPiezas();
    setElementosDeInterfazIniciales(interfaz);
    imprimirTablero();
  }

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
    colores.add("verde");
    colores.add("amarillo");
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

  // TODO: Segundo sprint
  /**
   *
   * @param filepath
   */
  public Chaturanga(String filepath) {
  }

  // TODO: Segundo sprint
  /**
   * Setea el estado inicial de las piezas
   * 
   * @param
   * @return
   **/
  public void setEstadoInicialDeLasPiezas() {

  }

  /**
   * Metodo encargado de mostrar y configurar elementos en la interfaz
   * 
   * @param interfaz
   */
  public void setElementosDeInterfazIniciales(InterfazGraficaGenerica interfaz) {
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

    /** Guardar Partida */
    ActionListener guardarPartida = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        guardarPartida();
      }
    };
    interfaz.agregarBoton("Guardar", guardarPartida, 102, 0);

    /**Color de los jugadores */
    String datos  = "";
    for (int i = 0; i < this.jugadores.length; i++ ) {
      datos = jugadores[i].getNombre()+ ": Juega con"+ jugadores[i].getColor()+"\n";
    }
    JLabel informacionJugador = new JLabel(datos);
    informacionJugador.setBounds(500, 500, 0, 0);
    interfaz.add(informacionJugador);
  }

  /*----------------- De Partida Abstracta---------------------*/

  // TODO: Segundo Sprint
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

  // TODO: Segundo Sprint
  /**
   * Metodo encargado de verificar que el juego haya terminado
   */
  public boolean elJuegoHaTerminado() {
    return false;
  }

  /**
   * Metodo de clase abstracta encargado de cargar la partida
   * 
   * @param filepath recibe un string con un path
   * @return un objeto de toipo PartidaAbstracta
   */
  public PartidaAbstracta cargarPartida(String filepath) {
    return this;
  }

  /**
   * Formato: Indice de Jugador actual (piezas perdidas) Jugador actual 1 :
   * Nombre, Color, [Caballo_verde, Elefante_verde, Peon_verde] Jugador actual 2
   * Jugador actual 3 Jugador actual 4
   * 
   * Fila tablero 1 : [ true{Caballo_verde}, false {}, false {}, false {}, false
   * {}, false {}, false {}, false {},] Fila tablero 2 Fila tablero 3 Fila tablero
   * 4 Fila tablero 5 Fila tablero 6 Fila tablero 7 Fila tablero 8
   */

  /**
   * Metodo encargado de convertir a un string
   * 
   * @return String
   */
  public String to_String() {
    String chaturanga = "";
    chaturanga += this.jugadorActual + "\n\n";
    // Jugadores
    for (int jugador = 0; jugador < this.TOTAL_JUGADORES; jugador++) {
      chaturanga += this.jugadores[jugador].to_String();
    }
    chaturanga += "\n" + this.tablero.toString();
    return chaturanga;
  }

}