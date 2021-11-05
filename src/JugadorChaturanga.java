import java.util.ArrayList;

import javax.swing.JOptionPane;

public class JugadorChaturanga extends JugadorAbstracto {
  String nombre;
  String color;
  ArrayList<PiezaAbstracta> piezasPerdidas;
  int cantidadPiezasPerdidas = 0;

  public JugadorChaturanga(String nombre, String color) {
    this.nombre = nombre;
    this.color = color;
    // TODO
    this.piezasPerdidas = new ArrayList<PiezaAbstracta>(); 
    pedirDatos();
  }

  public String to_String(){
    String jugador = this.nombre + ", "+ this.color + ", [";
    for (int piezaPerdida = 0; piezaPerdida < this.cantidadPiezasPerdidas; piezaPerdida++) {
      jugador += "{" + piezasPerdidas.get(piezaPerdida).toString() + "}";
    }
    jugador += "\n";
    return jugador;
  }

  public void pedirDatos() {
    this.nombre = JOptionPane.showInputDialog("Digite el nombre del jugador:");
    String []  colorArray = {"Blanco", "Verde", "Amarillo", "Rojo"};
    int option = JOptionPane.showOptionDialog(null, "Eliga un color para el jugador: ", 
      "Colores", 0, JOptionPane.QUESTION_MESSAGE, null, colorArray, "Blanco");
    
    if (option == 0) {
      this.color = "blanco";
    } else if (option == 1) {
      this.color = "verde";
    }else if (option == 2) {
      this.color = "amarillo";
    } else if (option == 3) {
      this.color = "rojo";
    }

  }
}