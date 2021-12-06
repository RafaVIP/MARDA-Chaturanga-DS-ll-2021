import java.util.ArrayList;

/**
 * Proyecto Programado: Diseño Rafael Porras (B75915) Fabian
 * Gonzalez (B83493) Kevin Salas (B87161) Wendy Ortiz (B75594)
 **/

public abstract class PiezaAbstracta {

  /**
   * Metodo encargado de verificar los movimientos validos para la pieza
   * 
   * @param tablero
   * @param ejeXActual
   * @param ejeYActual
   * @return Arraylist de string en formato [0] = x,y [1] = x1,y1
   */
  abstract ArrayList<String> getPosiblesMovimientos(Casilla[][] tablero, int ejeXActual, int ejeYActual);

  /**
   * Metodo encargado de obtener el path del archivo imagen
   * 
   * @return String del path de la imagen
   */
  abstract String getImageFilePath();

  /**
   * Metodo encargado de obtener el colorde la pieza en la casilla actual
   * 
   * @return Color de la pieza en la casilla actual
   */
  abstract String getColor();

  /**
   * Retorna el nombre de la pieza
   * 
   * @return nombre de la pieza
   */
  abstract String getNombre();

  /**
   * Metodo encargado de convertir a string
   * 
   * @return String
   */
  public abstract String to_String();

  /**
   * Verifica la casilla donde se encuentra la pieza
   * 
   * @param tablero
   * @param fila
   * @param columna
   * @return retorna el color de la pieza
   */
  public String checkCasilla(Casilla[][] tablero, int fila, int columna) {
    if (tablero[fila][columna].contenido == null) {
      return "null";
    } else if (tablero[fila][columna].contenido.getColor().equals("rojo")) {
      return "rojo";
    }
    return "blanco";
  }

  /**
   * Metodo encargado de crear el formato de las coordenadas
   * 
   * @param x
   * @param y
   * @return String con el formato
   */
  public String formatCords(int x, int y) {
    return "(" + Integer.toString(x) + ", " + Integer.toString(y) + ")";
  }
}