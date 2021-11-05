public class Casilla {

  private int TAM_CASILLA = 75;
  private int BASE = 50;

  public PiezaAbstracta contenido;
  public int fila, columna;
  public InterfazGraficaGenerica interfaz;
  

  public Casilla(final int fila, final int columna, InterfazGraficaGenerica interfaz){
    this.contenido = null;
    this.fila = fila;
    this.columna = columna;
    this.interfaz = interfaz;
  }

  public void setContenido(PiezaAbstracta contenido) {
    this.contenido = contenido;
  }

  void imprimir(){
    if (this.contenido != null) {
        imprimirPieza();
      }
    // Imprime la casilla
    if ((esPar(this.fila) && !esPar(this.columna)) || (!esPar(this.fila) && esPar(this.columna))){ // Casilla Blanca
      imprimirCasilla("blanca");
      
    } else { // Casilla Negra
      imprimirCasilla("negra");
    }
    
  }

  void imprimirCasilla(final String color){
    // Imprimir las casillas del tablero
    String filePath = "imgs/Casilla_" + color + ".png";
    this.dibujarEnInterfaz(filePath);
  }

  void imprimirPieza() {
    String filePath = this.contenido.getImageFilePath();
    this.dibujarEnInterfaz(filePath);
  }

  void dibujarEnInterfaz( String filePath){
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