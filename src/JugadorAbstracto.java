/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161)
 ** Wendy Ortiz (B75594)
 **/

/**
 * @brief Clase abstracta para Jugador
 */
public abstract class JugadorAbstracto {
  /// Metodos abstractos

  /**
   * @brief Metodo encargado de convertir a String
   * @return String (convertido)
   */
  public abstract String to_String();

  /**
   * @brief Metodo encargado de obtener el color que eligio el jugador
   * @return String (Color)
   */
  public abstract String getColor();
}
