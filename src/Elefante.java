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
  public ArrayList<String> getPosiblesMovimientos(Casilla[][] tablero, int ejeXActual, int ejeYActual){
    ArrayList<String> movimientos = new ArrayList<String>();
    String my_color = tablero[ejeXActual][ejeYActual].contenido.getColor();
    int dos_par = 2;   // 2 ->  2 -> -2 -> -2 
    int dos_impar = 2; // 2 -> -2 ->  2 -> -2
    for(int i = 0; i < 4; ++i) {
      if(i < 4) {
        if (checkMove(tablero, ejeXActual + dos_par, ejeYActual + dos_impar, my_color)) {
          movimientos.add(formatCords(ejeXActual + dos_par, ejeYActual + dos_impar));
        }
      }
      if(i%2 == 0) {
        dos_par *= -1;
      }
      dos_impar *= -1;
    }
    return movimientos;
  }

  private boolean checkMove(Casilla[][] tablero, int x, int y, String my_color) {
    if((x > -1 && x < 8) && (y > -1 && y < 8)) {
      if (!checkCasilla(tablero, x, y).equals(my_color) || checkCasilla(tablero, x, y).equals("null")) {
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
