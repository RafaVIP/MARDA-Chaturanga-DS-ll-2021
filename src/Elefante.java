import java.util.ArrayList;

/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161) 
 ** Wendy Ortiz (B75594)
 **/

public class Elefante extends PiezaAbstracta {
  /// Atributos de la clase
  public String nombre;

  public String color;

  /// Constructor
  public Elefante(final String color) {
    this.nombre = "Elefante";
    this.color = color;
  }

  /***/
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
    return this.nombre + "\n" + this.color + "\n";
  }
}
