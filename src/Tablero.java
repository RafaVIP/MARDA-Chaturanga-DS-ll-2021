package Chaturanga;

import java.util.ArrayList; // import the ArrayList class ... tomado de https://www.w3schools.com/java/java_arraylist.asp

public class Tablero {

  public class Jugador {
    public String nombre;

    public String color;

    public ArrayList<Pieza> piezas;

    public ArrayList<Pieza> piezasPerdidas;
  }
  
  public Casilla [][] tablero;

  public int filas;

  public int columnas;



  public Tablero(final int filas, final int columnas) {
    this.filas = filas;
    this.columnas = columnas;
    this.tablero = new [filas][columnas];

    // Setea Casillas
    for (int fila = 0; fila < this.filas; fila++){
      for (int columna = 0; columna < this.columna; columna++) {
        this.tablero[fila][columna] = new Casilla(fila, columna);
      }
    }

    // Setea Piezas Iniciales
      // Deberia ir aqui en caso de ser un tablero generico deberia hacerlo otro??
  }

  public boolean verificarFinal() {

  }

  void imprimirTablero(){
    for (int fila = 0; fila < this.filas; fila++){
      for (int columna = 0; columna < this.columna; columna++) {
        this.tablero[fila][columna].imprimir();
      }
    }
  }
}