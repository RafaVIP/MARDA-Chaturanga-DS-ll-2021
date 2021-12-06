import java.util.ArrayList;

/**
 * Proyecto Programado: Diseño Rafael Porras (B75915) Fabian
 * Gonzalez (B83493) Kevin Salas (B87161) Wendy Ortiz (B75594)
 **/

public class Reina extends PiezaAbstracta {
  /// Atributos de la clase
  public String nombre;

  public String color;

  /// Constructor
  public Reina(final String color) {
    this.nombre = "Reina";
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
    int uno_par = 1; // 1 -> 1 -> -1 -> -1
    int uno_impar = 1; // 1 -> -1 -> 1 -> -1
    for (int i = 0; i < 4; ++i) {
      if (checkMove(tablero, ejeXActual + uno_par, ejeYActual + uno_impar, my_color)) {
        movimientos.add(formatCords(ejeXActual + uno_par, ejeYActual + uno_impar));
      }
      if (i % 2 == 0) {
        uno_par *= -1;
      }
      uno_impar *= -1;
    }
    return movimientos;
  }

  /**
   * Metodo encargado de verificar el movimiento de la pieza
   * 
   * @param tablero
   * @param x
   * @param y
   * @param my_color
   * @return True si el movimiento es valido
   */
  private boolean checkMove(Casilla[][] tablero, int x, int y, String my_color) {
    if ((x > -1 && x < 8) && (y > -1 && y < 8)) {
      if (!checkCasilla(tablero, x, y).equals(my_color) || checkCasilla(tablero, x, y).equals("null")) {
        return true;
      }
    }
    return false;
  }

  /**
   * Override de Metodo encargado de obtener el path del archivo imagen
   * 
   * @return String del path de la imagen
   */
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
