import java.util.ArrayList;

/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161) 
 ** Wendy Ortiz (B75594)
 **/

public class Peon extends PiezaAbstracta {
  /// Atributos de la clase
  public String nombre;

  public String color;

  /// Constructor
  public Peon(final String color) {
    this.nombre = "Peon";
    this.color = color;
  }

  /**
   * Override de Metodo movimiento heredado de Pieza Abstracta, indica el
   *        movimiento de la ficha
   * @return true si el movimiento se hizo correctamente
   */
  @Override
  public ArrayList<String> getPosiblesMovimientos(Casilla[][] tablero, int filas, int columnas, int ejeXActual, int ejeYActual, int direccion) {
    ArrayList<String> movimientos = new ArrayList<String>();

    return movimientos;
  }

  /**
   * Override de Metodo encargado de obtener el path del archivo imagen
   * @return String del path de la imagen
   */
  @Override
  public String getImageFilePath() {
    return "imgs/" + this.nombre + "_" + color + ".png";
  }

  /**
   * Override de Metodo encargado de convertir a string
   * @return String
   */
  @Override
  public String to_String() {
    return this.nombre + "_" + this.color;
  }
}
