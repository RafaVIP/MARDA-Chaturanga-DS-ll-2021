
/**
 ** Primera iteración Proyecto Programado: Diseño Rafael Porras (B75915) Fabian
 * Gonzalez (B83493) Kevin Salas (B87161) Wendy Ortiz (B75594)
 **/

import java.util.ArrayList;

public class ReglasChaturanga { // extends ReglasPartidaAbstracta {
  /*----------------- Propios de Chaturanga------------------*/

  /// Contructor
  public ReglasChaturanga() {}

  // Comprueba si el jugador contrario puede mover alguna pieza o si ya perdio
  public boolean quedanMovimientos(Casilla[][] tablero, int jugadorActual) {
    ArrayList<String> movimientos = new ArrayList<String>();
    String my_color = (jugadorActual % 2 == 0) ? "blanco" : "rojo";
    int posibles_movimientos = 0;
    for(int x = 0; x < 8; ++x) {
      for(int y = 0; y < 8; ++y) {
        try{
          if(tablero[x][y].getContenido() != null) {
            // Si a mi color contrario no le quedan movimientos, entonces victoria
            if(tablero[x][y].contenido.getColor().equals(my_color) != false) {
              movimientos = tablero[x][y].contenido.getPosiblesMovimientos(tablero, x, y);
              System.out.println("Sel casilla: (" + x + ", " + y + ")");
              movimientos = filtrarMovimientos(tablero, jugadorActual, movimientos, x, y, tablero[x][y].contenido);
              if(movimientos.size() > 0) {
                ++posibles_movimientos;
                for(int que = 0; que < movimientos.size(); ++que) {
                  System.out.println("Aun valido: " + movimientos.get(que) + " soy " + my_color + " (" + x + ", " + y + ")");
                }
                return true;
              }
            }
          }
        } catch (Exception t) {
          System.out.println("Error en casilla: (" + x + ", " + y + ")");
        }
      }
    }
    if(posibles_movimientos == 0) {
      return false;
    }
    return true;
  }

  /**
   * Esta matriz marca todos los lugares donde se pueden atacar 
   * las piezas enemigas. Se usa para revisar que jugadas son validas. 
   * Safe = "" ||
   * @param tablero
   * @return ArrayList<String>
   */
  private ArrayList<String> crearJaqueMatriz(Casilla[][] tablero, int jugadorActual) {
    ArrayList<String> jacque_matriz = new ArrayList<String>();
    Casilla[][] tablero_copia = tablero;
    String my_color = (jugadorActual % 2 == 0) ? "blanco" : "rojo";
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

  /**
   * Metodo encargado de copiar una matriz
   * @param tablero
   * @return Casilla[][] copia
   */
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

  /**
   * Remueve movimientos que ponen en peligro al rey
   * @param movimientos Movimientos a filtrar
   * @param x_sel x seleccionada
   * @param y_sel y seleccionada
   * @param piezaSeleccionada_actual pieza seleccionada
   * @return ArrayList<String>
   */
  public ArrayList<String> filtrarMovimientos(Casilla[][] tablero, int jugadorActual, ArrayList<String> movimientos, int x_sel, int y_sel, PiezaAbstracta piezaSeleccionada_actual) {
    String my_color = (jugadorActual % 2 == 0) ? "blanco" : "rojo";
    // Remover movimientos de piezas rojas, si es turno blanco y viceversa
    if (movimientos.size() > 0) {
      if (tablero[x_sel][y_sel].getColor().equals(my_color) == false) {
        int mov_len = movimientos.size() - 1;
        for (int i = mov_len; i >= 0; --i) {
          movimientos.remove(i);
        }
      }
    }
    int total_moves = movimientos.size() - 1;
    boolean once = false;
    for (int current_mov = total_moves; current_mov >= 0; --current_mov) {
      Casilla[][] tablero_temporal = copiarTablero(tablero);
      if (tablero_temporal[x_sel][y_sel].contenido != null) {
        if (tablero_temporal[x_sel][y_sel].contenido.getColor().equals(my_color)) {
          if (tablero_temporal[x_sel][y_sel].contenido.getNombre().equals("Rey") && once == false) {
            System.out.println("Tengo seleccionado al rey (" + x_sel + ", " + y_sel + ")");
            once = true;
          }
        }
      }
      // Hacer la jugada en el tablero temporal
      String movimiento = movimientos.get(current_mov);
      int a = movimiento.charAt(1) - 48;
      int b = movimiento.charAt(4) - 48;
      tablero_temporal[a][b].setContenido(piezaSeleccionada_actual);
      tablero_temporal[x_sel][y_sel].setCasillaVacia();
      // Actualizar la jacque matriz temporal
      ArrayList<String> jacque_matriz = crearJaqueMatriz(tablero_temporal, jugadorActual);
      // Revisar si el rey se encuentra en Jaque en la jacque matriz temporal
      for (int x = 0; x < 8; ++x) {
        for (int y = 0; y < 8; ++y) {
          String estado = jacque_matriz.get((8 * x) + y);
          if (estado.equals("jaque")) {
            if (tablero_temporal[x][y].contenido != null) {
              if (tablero_temporal[x][y].contenido.getColor().equals(my_color)) {
                if (tablero_temporal[x][y].contenido.getNombre().equals("Rey")) {
                  movimientos.remove(current_mov);
                  System.out.println("Eliminando jugada en (" + x + ", " + y + ")" );
                }
              }
            }
          }
        }
      }
    }
    return movimientos;
  }
}
