/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161)
 ** Wendy Ortiz (B75594)
 **/

import java.io.*;

public class Tablero {
  /// Atributos de la clase
  public Casilla[][] tablero;

  public int filas;

  public int columnas;

  /**
   * @brief Metodo constructor encargado de construir el objeto tablero
   * @param filas
   * @param columnas
   * @param interfaz
   */
  public Tablero(String pathfile, final int filas, final int columnas, InterfazGraficaGenerica interfaz) {
    this.filas = filas;
    this.columnas = columnas;
    this.tablero = new Casilla[filas][columnas];
    try {
      System.out.println(pathfile);
      BufferedReader bf = new BufferedReader(new FileReader(pathfile));
      String tipo = "";
      String color = "";
      String tmp = "";
      // Setea Casillas  
      for (int fila = 0; fila < this.filas; fila++){
        for (int columna = 0; columna < this.columnas; columna++) {
          this.tablero[fila][columna] = new Casilla(fila, columna, interfaz);
          tipo = bf.readLine();
          color = bf.readLine();
          
          PiezaAbstracta pieza = crearPiezaAbstracta(tipo, color);
          this.tablero[fila][columna].setContenido(pieza);
        }
        tmp = bf.readLine();
      }
      bf.close();
    } catch (Exception e) { System.out.println("Error en lectura de la partida"); }
  }

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
   * @brief Metodo encargado de imprimir el tablero en pantalla
   */
  public void imprimirTablero() {
    for (int fila = 0; fila < this.filas; fila++) {
      for (int columna = 0; columna < this.columnas; columna++) {
        this.tablero[fila][columna].imprimir();
      }
    }
  }

  /**
   * @brief Metodo encargado de convertir a string
   * @return String convertido
   */
  public String toString() {
    String tablero = "[";
    for (int fila = 0; fila < this.filas; fila++) {
      for (int columna = 0; columna < this.columnas; columna++) {
        if (this.tablero[fila][columna].getContenido() != null) {
          tablero += " true{" + this.tablero[fila][columna].getContenido().to_String() + "},";
        } else {
          tablero += " false{},";
        }
      }
      tablero += '\n';
    }
    tablero += "]\n";
    return tablero;
  }
}