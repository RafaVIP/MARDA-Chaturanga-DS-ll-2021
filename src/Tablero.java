/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161)
 ** Wendy Ortiz (B75594)
 **/

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
  public Tablero(final int filas, final int columnas, InterfazGraficaGenerica interfaz) {
    this.filas = filas;
    this.columnas = columnas;
    this.tablero = new Casilla[filas][columnas];
    // Setea Casillas
    for (int fila = 0; fila < this.filas; fila++) {
      for (int columna = 0; columna < this.columnas; columna++) {
        this.tablero[fila][columna] = new Casilla(fila, columna, interfaz);
        PiezaAbstracta pieza;
        if (fila % 2 == 0) {
          pieza = new Elefante("verde");
        }

        else {
          pieza = new Barco("rojo");
        }

        this.tablero[fila][columna].setContenido(pieza);
      }
    }
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