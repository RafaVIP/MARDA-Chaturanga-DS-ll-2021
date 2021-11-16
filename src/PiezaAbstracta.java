import java.util.ArrayList;

/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161) 
 ** Wendy Ortiz (B75594)
 **/

public abstract class PiezaAbstracta {

  /**
   * 
   * @param tablero
   * @param filas
   * @param columnas
   * @param ejeXActual
   * @param ejeYActual
   * @param direccion
   * @return Arraylist de string en formato [0] = x,y [1] = x1,y1
   */
  abstract ArrayList<String> getPosiblesMovimientos(Casilla[][] tablero, int ejeXActual, int ejeYActual);

  /**
   * Metodo encargado de obtener el path del archivo imagen
   * @return String del path de la imagen
   */
  abstract String getImageFilePath();

  /**
   * Metodo encargado de obtener el colorde la pieza en la casilla actual
   * @return Color de la pieza en la casilla actual
   */
  abstract String getColor();


  /**
   * Retorna el nombre de la pieza
   * @return nombre de la pieza
   */
  abstract String getNombre();

  /**
   * Metodo encargado de convertir a string
   * @return String
   */
  public abstract String to_String();

  public String checkCasilla(Casilla[][] tablero, int fila, int columna) {
    if (tablero[fila][columna].contenido == null) {
      return "null";
    } else if(tablero[fila][columna].contenido.getColor().equals("rojo")) {
      return "rojo";
    }
    return "blanco";
  }

  public String formatCords(int x, int y) {
    return "(" + Integer.toString(x) + ", " + Integer.toString(y) + ")";
  }
}