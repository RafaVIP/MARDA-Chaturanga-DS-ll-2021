import Dado;
import java.util.ArrayList; // import the ArrayList class ... tomado de https://www.w3schools.com/java/java_arraylist.asp
import Pieza;

public class Tablero {

  public class Jugador {
    public String nombre;

    public String color;

    public ArrayList<Pieza> piezas;

    public ArrayList<Pieza> piezasPerdidas;
  }
  
  public class Casilla {
    public boolean ocupada = false;
  } 

  public Casilla [][] tablero;

  public int filas;

  public int columnas;

  public Dado dado;

  public Tablero(final int filas, final int columnas) {
    this.filas = filas;
    this.columnas = columnas;
    this.tablero = new [filas][columnas];
  }

  public boolean verificarFinal() {

  }

  public void inicializarTablero() {

  }
}