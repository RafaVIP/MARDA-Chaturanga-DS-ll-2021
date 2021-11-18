/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161)
 ** Wendy Ortiz (B75594)
 **/

import java.util.ArrayList;

public class Tablero {
  /// Atributos de la clase
  public Casilla[][] tablero;

  public int filas;

  public int columnas;

  /**
   * Metodo constructor encargado de construir el objeto tablero
   * @param filas
   * @param columnas
   * @param interfaz
   */
  public Tablero(Casilla[][] tablero, final int filas, final int columnas) {
    this.filas = filas;
    this.columnas = columnas;
    this.tablero = tablero;
  }

  /**
   * Crea una pieza abstracta distinta
   * @param tipo
   * @param color
   * @return
   */
  private PiezaAbstracta crearPiezaAbstracta(final String tipo, final String color) {
    if(tipo.equals("rey")) {
      return new Rey(color);
    }
    if(tipo.equals("elefante")) {
      return new Elefante(color);
    }
    if(tipo.equals("barco")) {
      return new Barco(color);
    }
    if(tipo.equals("caballo")) {
      return new Caballo(color);
    }
    if(tipo.equals("peon")) {
      return new Peon(color);
    }
    return null;
  }

  /**
   * Metodo encargado de imprimir el tablero en pantalla
   */
  public ArrayList<ArrayList<ArrayList<String>>> imprimirTablero() {
    ArrayList<ArrayList<ArrayList<String>>> tablero = new ArrayList<ArrayList<ArrayList<String>>>();
    for (int fila = 0; fila < this.filas; fila++) {
      for (int columna = 0; columna < this.columnas; columna++) {
        tablero.add(this.tablero[fila][columna].imprimir());
      }
    }
    return tablero;
  }

  /**
   * Metodo encargado de convertir a string
   * @return String convertido
   */
  public String toString() {
    String tablero = "";
    for (int fila = 0; fila < this.filas; fila++) {
      for (int columna = 0; columna < this.columnas; columna++) {
        if (this.tablero[fila][columna].getContenido() != null) {
          tablero += this.tablero[fila][columna].getContenido().to_String();
        } else {
          tablero += "null\nnull\n";
        }
      }
      tablero += '\n';
    }
    return tablero;
  }
}