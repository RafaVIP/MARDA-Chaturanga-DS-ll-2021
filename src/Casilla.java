import java.util.ArrayList;

/**
 ** Primera iteración Proyecto Programado: Diseño Rafael Porras (B75915) Fabian
 * Gonzalez (B83493) Kevin Salas (B87161) Wendy Ortiz (B75594)
 **/

public class Casilla {
  /// Atributos de la clase
  private int TAM_CASILLA = 75;
  private int BASEx = 5;
  private int BASEy = 25;

  public PiezaAbstracta contenido;
  public int fila, columna;

  /**
   * Constructor de la clase
   * 
   * @param fila
   * @param columna
   */
  public Casilla(final int fila, final int columna) {
    this.contenido = null;
    this.fila = fila;
    this.columna = columna;
  }

  /**
   * Metodo encargado de configurar el contenido de una pieza abstracta
   * 
   * @param contenido
   */
  public void setContenido(PiezaAbstracta contenido) {
    this.contenido = contenido;
  }

  /**
   * Metodo encargado de imprimir casilla
   * 
   * @return ArrayList<ArrayList<String>>
   */
  ArrayList<ArrayList<String>> imprimir() {
    // Arraylist<Arraylist<String>> = {{filepath,x,y},{Caballo,x,y}} o
    // {{filepath,x,y},{}}
    ArrayList<ArrayList<String>> casilla = new ArrayList<ArrayList<String>>();
    if (this.contenido != null) {
      casilla.add(imprimirPieza());
    }
    /*
     * // Imprime la casilla if ((esPar(this.fila) && !esPar(this.columna)) ||
     * (!esPar(this.fila) && esPar(this.columna))) { // Casilla Blanca
     * casilla.add(imprimirCasilla("blanca"));
     * 
     * } else { // Casilla Negra casilla.add(imprimirCasilla("negra")); }
     */
    return casilla;
  }

  /**
   * Metodo encargado de imprimir casilla con su respectivo color
   * 
   * @param color
   * @return ArrayList<String>
   */
  ArrayList<String> imprimirCasilla(final String color) {
    ArrayList<String> casilla = new ArrayList<String>();
    ArrayList<String> coordenadas = getCoordenadasDeDibujo();
    String filePath = "imgs/Casilla_" + color + ".png";
    // Agrega la casilla
    casilla.add(filePath);
    // Agrega las coordenadas donde deberia imprimirse
    for (int coordenada = 0; coordenada < coordenadas.size(); coordenada++) {
      casilla.add(coordenadas.get(coordenada));
    }
    return casilla;
  }

  /**
   * Metodo encargado de imprimir la pieza en la casilla
   * 
   * @return ArrayList<String>
   */
  ArrayList<String> imprimirPieza() {
    ArrayList<String> pieza = new ArrayList<String>();
    ArrayList<String> coordenadas = getCoordenadasDeDibujo();
    String filePath = this.contenido.getImageFilePath();
    // Agrega la pieza
    pieza.add(filePath);
    // Agrega las coordenadas donde deberia imprimirse
    for (int coordenada = 0; coordenada < coordenadas.size(); coordenada++) {
      pieza.add(coordenadas.get(coordenada));
    }
    return pieza;
  }

  /**
   * Metodo encargado de dibujar en la interfaz
   * 
   * @param filePath
   * @return ArrayList<String>
   */
  ArrayList<String> getCoordenadasDeDibujo() {
    ArrayList<String> coordenadas = new ArrayList<String>();
    int ejeX = this.fila;
    int ejeY = this.columna;
    coordenadas.add(Integer.toString(ejeX));
    coordenadas.add(Integer.toString(ejeY));
    return coordenadas;
  }

  /**
   * Metodo encargado de convertir una Casilla a vacia
   */
  void setCasillaVacia() {
    this.contenido = null;
  }

  /**
   * Metodo encargado de obtener el contenido
   * 
   * @return PiezaAbstracta
   */
  PiezaAbstracta getContenido() {
    return this.contenido;
  }

  /**
   * Metodo encargado de obtener el colorde la pieza en la casilla actual
   * 
   * @return Color de la pieza en la casilla actual
   */
  public String getColor() {
    return this.contenido.getColor();
  }

  /**
   * Metodo encargado de revidar si un núméro es par
   * 
   * @param numero
   * @return true si es par
   */
  boolean esPar(final int numero) {
    return numero % 2 == 0;
  }
}