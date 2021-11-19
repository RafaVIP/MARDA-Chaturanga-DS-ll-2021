import java.util.ArrayList;

/**
 * Primera iteración Proyecto Programado: Diseño Rafael Porras (B75915) Fabian
 * Gonzalez (B83493) Kevin Salas (B87161) Wendy Ortiz (B75594)
 **/

public class Barco extends PiezaAbstracta {
  /// Atributos de la clase
  public String nombre;

  public String color;

  /// Constructor
  public Barco(final String color) {
    this.nombre = "Barco";
    this.color = color;
  }

  /**
   * Override de Metodo movimiento heredado de Pieza Abstracta, indica el
   * movimiento de la ficha
   * 
   * @return true si el movimiento se hizo correctamente
   */
  @Override
  public ArrayList<String> getPosiblesMovimientos(Casilla[][] tablero, int ejeXActual, int ejeYActual) {
    ArrayList<String> movimientos = new ArrayList<String>();
    String my_color = tablero[ejeXActual][ejeYActual].contenido.getColor();
    int borde = -1; // -1 -> 8 -> -1 -> 8
    int direccion = -1; // -1 -> 1 -> -1 -> 1
    int x_actual = 0;
    int y_actual = 0;
    for (int i = 0; i < 4; ++i) {
      // checka x en las primeras 2 iteraciones, luego y en las ultimas 2
      for (int casilla_actual = i < 2 ? ejeXActual + direccion
          : ejeYActual + direccion; casilla_actual != borde; casilla_actual += direccion) {
        if (i < 2) {
          x_actual = casilla_actual;
          y_actual = ejeYActual;
        } else {
          x_actual = ejeXActual;
          y_actual = casilla_actual;
        }
        // System.out.println("Iteracion " + i + " - casilla actual: " +
        // formatCords(x_actual, y_actual));
        if (checkCasilla(tablero, x_actual, y_actual).equals("null")) {
          movimientos.add(formatCords(x_actual, y_actual));
        } else {
          if (!checkCasilla(tablero, x_actual, y_actual).equals(my_color)) {
            movimientos.add(formatCords(x_actual, y_actual));
          }
          casilla_actual = borde - direccion;
        }
      }
      if (i % 2 == 0) { // -1 -> 8 -> -1 -> 8
        borde = 8;
      } else {
        borde = -1;
      }
      direccion *= -1;
    }
    return movimientos;
  }

  /**
   * Override de Metodo encargado de obtener el path del archivo imagen
   * 
   * @return String del path de la imagen
   **/
  @Override
  public String getImageFilePath() {
    return "imgs/" + this.nombre + "_" + color + ".png";
  }

  /**
   * Override de Metodo encargado de convertir a string
   * 
   * @return String
   */
  @Override
  public String to_String() {
    return this.nombre + "\n" + this.color + "\n";
  }

  /**
   * Retorna el nombre de la pieza
   * 
   * @return nombre de la pieza
   */
  @Override
  public String getNombre() {
    return this.nombre;
  }

  /**
   * Retorna el color de la pieza
   * 
   * @return Color de la pieza
   */
  @Override
  public String getColor() {
    return this.color;
  }
}
