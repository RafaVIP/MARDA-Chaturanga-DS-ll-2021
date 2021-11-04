package Chaturanga;

public class Casilla {

  int TAM_CASILLA = 75;
  int BASE = 50;

  public PiezaAbstracta contenido;
  public int fila, columna;
  public InterfazGraficaGenerica interfaz;
  

  public Casilla(final int fila, final int columna){
    this.contenido = null;
    this.fila = fila;
    this.columna = columna;
  }

  public setContenido(PiezaAbstracta contenido) {
    this.contenido = contenido;
  }

  void imprimir(){
    // Imprime la casilla
    if ((esPar(this.fila) && !esPar(this.columna)) || ((!esPar(this.fila) && esPar(this.columna)){ // Casilla Blanca
      imprimirCasilla("blanca");
    } else { // Casilla Negra
      imprimirCasilla("negra");
    }
    if (this.contenido != null) {
        imprimirPieza();
      }
  }

  void imprimirCasilla(final string color){
    // Imprimir las casillas del tablero
    string filePath = "src/Chatu/images/Casilla_" + color + ".png";
    this.dibujarEnInterfaz(filePath);
  }

  void imprimirPieza() {
    string filePath = this.contenido.getImageFilePath();
    this.dibujarEnInterfaz(filePath);
  }

  void dibujarEnInterfaz(final string filePath){
    int ejeX = this.BASE + (this.TAM_CASILLA * this.fila);
    int ejeY = this.BASE + (this.TAM_CASILLA * this.columna);
    this.interfaz.printImage(filePath, ejeX, ejeY);
  }

  void setCasillaVacia(){
    this.contenido = null;
  }

  PiezaAbstracta getContenido(){
    return this.contenido;
  }

  boolean esPar(final int numero) {
    return numero % 2 == 0;
  }

  void setBaseYTamanoDeCasilla(final int base, final int tam_casilla){
    BASE = base;
    TAM_CASILLA = tam_casilla;
  }
}