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
  public ArrayList<String> getPosiblesMovimientos(Casilla[][] tablero, int ejeXActual, int ejeYActual) {
    ArrayList<String> movimientos = new ArrayList<String>();
    String my_color = tablero[ejeXActual][ejeYActual].contenido.getColor();
    int direccion = 0;
    if (my_color.equals("rojo")) {
      direccion = -1;
    } else {
      direccion = 1;
    }
    // Revisar movimiento frontal
    if (checkCasilla(tablero, ejeXActual+direccion, ejeYActual).equals("null")) {
        // System.out.println("Valida para avanzar: " + formatCords(ejeXActual+direccion, ejeYActual));
        movimientos.add(formatCords(ejeXActual+direccion, ejeYActual));
    }
    // Revisar para comer en las 2 diagonales
    if(checkTake(tablero, ejeXActual+direccion, ejeYActual-1, my_color)) {
      movimientos.add(formatCords(ejeXActual+direccion, ejeYActual-1));
    }
    if(checkTake(tablero, ejeXActual+direccion, ejeYActual+1, my_color)) {
      movimientos.add(formatCords(ejeXActual+direccion, ejeYActual+1));
    }
    return movimientos;
  }

  private boolean checkTake(Casilla[][] tablero, int x, int y, String my_color) {
    if(y > -1 && y < 8) {
      if (!checkCasilla(tablero, x, y).equals(my_color) && !checkCasilla(tablero, x, y).equals("null")) {
        // System.out.println("Valida para comer: " +  formatCords(x, y));
        return true;
      }
    }
    return false;
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

  /**
   * Retorna el nombre de la pieza
   * @return nombre de la pieza
   */
  @Override
  public String getNombre() {
    return this.nombre;
  }

  /**
   * Retorna el color de la pieza
   * @return Color de la pieza
   */
  @Override
  public String getColor() {
    return this.color;
  }
}
