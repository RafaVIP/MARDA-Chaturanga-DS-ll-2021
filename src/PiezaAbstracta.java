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
  abstract ArrayList<String> getPosiblesMovimientos(Casilla[][] tablero, int filas, int columnas, int ejeXActual, int ejeYActual, int direccion);

  /**
   * Metodo encargado de obtener el path del archivo imagen
   * @return String del path de la imagen
   */
  abstract String getImageFilePath();

  /**
   * Metodo encargado de convertir a string
   * @return String
   */
  public abstract String to_String();
}