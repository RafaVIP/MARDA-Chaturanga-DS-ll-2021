public class Tablero {

  public Casilla [][] tablero;

  public int filas;

  public int columnas;



  public Tablero(final int filas, final int columnas, InterfazGraficaGenerica interfaz) {
    this.filas = filas;
    this.columnas = columnas;
    this.tablero = new Casilla[filas][columnas];
    // Setea Casillas
    for (int fila = 0; fila < this.filas; fila++){
      for (int columna = 0; columna < this.columnas; columna++) {
        this.tablero[fila][columna] = new Casilla(fila, columna, interfaz);
        PiezaAbstracta pieza = new Elefante("verde");
        this.tablero[fila][columna].setContenido(pieza);
      }
    }
  }

  void imprimirTablero(){
    for (int fila = 0; fila < this.filas; fila++){
      for (int columna = 0; columna < this.columnas; columna++) {
        this.tablero[fila][columna].imprimir();
      }
    }
  }
}