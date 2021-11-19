import java.util.ArrayList;

/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161)
 ** Wendy Ortiz (B75594)
 **/

/**
 * Clase abstracta para Jugador
 */
public abstract class JugadorAbstracto {
  /// Metodos abstractos

  /**
   * Metodo encargado de convertir a String
   * 
   * @return String (convertido)
   */
  public abstract String to_String();

  /**
   * Metodo encargado de obtener el color que eligio el jugador
   * 
   * @return String (Color)
   */
  public abstract String getColor();

  /**
   * Metodo encargado de obtener el nombre del jugador
   * 
   * @return String (nombre)
   */
  public abstract String getNombre();

  /**
   * Metodo encargado de obtener el nombre del jugador
   * 
   * @return String (nombre)
   */
  public abstract ArrayList<PiezaAbstracta> getArrayPerdidos();

  public abstract void setArrayPerdidos(PiezaAbstracta pieza);
}
