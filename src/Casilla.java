/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161) 
 ** Wendy Ortiz (B75594)
**/

public class Casilla {
  /// Atributos de la clase
  private int TAM_CASILLA = 75;
  private int BASE = 50;

  public PiezaAbstracta contenido;
  public int fila, columna;
  public InterfazGraficaGenerica interfaz;

  /**
   * Constructor de la clase
   * @param fila
   * @param columna
   * @param interfaz
   */
  public Casilla(final int fila, final int columna, InterfazGraficaGenerica interfaz) {
    this.contenido = null;
    this.fila = fila;
    this.columna = columna;
    this.interfaz = interfaz;
  }

  /**
   * Metodo encargado de configurar el contenido de una pieza abstracta
   * @param contenido
   */
  public void setContenido(PiezaAbstracta contenido) {
    this.contenido = contenido;
  }

  /**
   * Metodo encargado de imprimir casilla
   */
  void imprimir() {
    if (this.contenido != null) {
      imprimirPieza();
    }
    // Imprime la casilla
    if ((esPar(this.fila) && !esPar(this.columna)) || (!esPar(this.fila) && esPar(this.columna))) { // Casilla Blanca
      imprimirCasilla("blanca");

    } else { // Casilla Negra
      imprimirCasilla("negra");
    }

  }

  /**
   * Metodo encargado de imprimir casilla con su respectivo color
   * @param color
   */
  void imprimirCasilla(final String color) {
    // Imprimir las casillas del tablero
    String filePath = "imgs/Casilla_" + color + ".png";
    this.dibujarEnInterfaz(filePath);
  }

  /**
   * Metodo encargado de imprimir la pieza en la casilla
   */
  void imprimirPieza() {
    String filePath = this.contenido.getImageFilePath();
    this.dibujarEnInterfaz(filePath);
  }

  /**
   * Metodo encargado de dibujar en la interfaz
   * @param filePath
   */
  void dibujarEnInterfaz(String filePath) {
    int ejeX = this.BASE + (this.TAM_CASILLA * this.fila);
    int ejeY = this.BASE + (this.TAM_CASILLA * this.columna);
    this.interfaz.printImage(filePath, ejeX, ejeY);
  }

  /**
   * Metodo encargado de convertir una Casilla a vacia
   */
  void setCasillaVacia() {
    this.contenido = null;
  }

  /**
   * Metodo encargado de obtener el contenido
   * @return PiezaAbstracta
   */
  PiezaAbstracta getContenido() {
    return this.contenido;
  }

  /**
   * Metodo encargado de revidar si un núméro es par
   * @param numero
   * @return true si es par
   */
  boolean esPar(final int numero) {
    return numero % 2 == 0;
  }

  /**
   * Metodo encargado de cambiar la base y el tamaño de la casilla
   * @param base
   * @param tam_casilla
   */
  void setBaseYTamanoDeCasilla(final int base, final int tam_casilla) {
    BASE = base;
    TAM_CASILLA = tam_casilla;
  }
}