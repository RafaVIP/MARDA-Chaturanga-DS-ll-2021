
/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161)
 ** Wendy Ortiz (B75594)
 **/

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class JugadorChaturanga extends JugadorAbstracto {
  /// Atributos de la clase
  String nombre;
  String color;
  ArrayList<PiezaAbstracta> piezasPerdidas;
  int cantidadPiezasPerdidas = 0;

  /// constructor
  public JugadorChaturanga(ArrayList<String> colorArray) {
    this.piezasPerdidas = new ArrayList<PiezaAbstracta>();
    pedirDatos(colorArray);
  }

  /// Constructor para partidas cargadas
  public JugadorChaturanga(String nombre, String color, ArrayList<PiezaAbstracta> piezasPerdidas, int cantidadPiezasPerdidas) {
    this.nombre = nombre;
    this.color = color;
    this.piezasPerdidas = piezasPerdidas;
    this.cantidadPiezasPerdidas = cantidadPiezasPerdidas;
  }
  
  /**
   * Metodo encargado de asignar y pedir los datos al jugador
   * @param colorArray un arreglo con los colores disponibles para el juego
   */
  public void pedirDatos(ArrayList<String> colorArray) {
    this.nombre = JOptionPane.showInputDialog("Digite el nombre del jugador:");
    String[] colorArrayCopy = new String[colorArray.size()];
    for (int i = 0; i < colorArrayCopy.length; i++) {
      colorArrayCopy[i] = colorArray.get(i);
    }
    int option = JOptionPane.showOptionDialog(null, "Eliga un color para el jugador: ", "Colores", 0,
        JOptionPane.QUESTION_MESSAGE, null, colorArrayCopy, colorArray.get(0));
    this.color = colorArray.get(option);
  }

  /**
   * Metodo encargado de retornar el valor del atributo color
   * @return String devuleve el valor del atributo color para este jugador
   */
  public String getColor() {
    return this.color;
  }

   /**
   * Metodo encargado de retornar el valor del atributo nombre
   * @return String devuleve el valor del atributo nombre del jugador
   */
  public String getNombre() {
    return this.nombre;
  }

   /**
   * Metodo encargado de retornar el valor del atributo nombre
   * @return String devuleve el valor del atributo nombre del jugador
   */
  public ArrayList<PiezaAbstracta> getArrayPerdidos() {
    return this.piezasPerdidas;
  }

  /**
   * Metodo encargado de convertir a string
   * @return retorna un string
   */
  public String to_String() {
    String jugador = this.nombre + "\n" + this.color + "\n";
    jugador += Integer.toString(this.cantidadPiezasPerdidas) + "\n";
    for (int piezaPerdida = 0; piezaPerdida < this.cantidadPiezasPerdidas; piezaPerdida++) {
      jugador += piezasPerdidas.get(piezaPerdida).toString();
    }
    return jugador;
  }
}
