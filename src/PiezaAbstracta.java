/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161) 
 ** Wendy Ortiz (B75594)
 **/

public abstract class PiezaAbstracta {
  /**
   ** @brief Metodo encargado de indicar el movimiento de la ficha
   ** @return true si el movimiento se hizo correctamente
   **/
  abstract boolean movimiento();

  /**
   ** @brief Metodo encargado de obtener el path del archivo imagen
   ** @return String del path de la imagen
   **/
  abstract String getImageFilePath();

  /**
   ** @brief Metodo encargado de convertir a string
   ** @return String
   */
  public abstract String to_String();
}