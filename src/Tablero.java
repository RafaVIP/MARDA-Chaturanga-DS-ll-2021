package Chaturanga;

public class Tablero {

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

    imprimirTablero();
  }

  void imprimirTablero(){
    for (int fila = 0; fila < this.filas; fila++){
      for (int columna = 0; columna < this.columna; columna++) {
        this.tablero[fila][columna].imprimir();
      }
    }
  }
}