import java.util.ArrayList;

public class JugadorChaturanga extends JugadorAbstracto {
  String nombre;
  String color;
  ArrayList<PiezaAbstracta> piezasPerdidas;
  int cantidadPiezasPerdidas = 0;

  public JugadorChaturanga(String nombre, String color) {
    this.nombre = nombre;
    this.color = color;
    this.piezasPerdidas = new ArrayList<PiezaAbstracta>(); // ver esto
  }

  public String to_String(){
    String jugador = this.nombre + ", "+ this.color + ", [";
    for (int piezaPerdida = 0; piezaPerdida < this.cantidadPiezasPerdidas; piezaPerdida++) {
      jugador += "{" + piezasPerdidas.get(piezaPerdida).toString() + "}";
    }
    jugador += "\n";
    return jugador;
  }
}