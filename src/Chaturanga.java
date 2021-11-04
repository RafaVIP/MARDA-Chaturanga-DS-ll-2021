package Chaturanga;
import java.util.ArrayList;

public class Chaturanga extends PartidaAbstracta{

  int jugadorActual = 0;
  Tablero tablero;
  ArrayList<Jugador> jugadores;
  /*----------------- De Partida Abstracta*/
  public  void iniciarPartida() {
    /*
    int jugadorActual = 0;
    int [2] coordenadas elegidas;
    while(!elJuegoHaTerminado()){
     coordenadasElegidas = jugador.solicitarCasillaAMoverse();
        // Check si la casilla elegida es valida
      if (tablero[x_actual][y_actual].movimiento(x_actual, y_actual, x_solicitado, y_solicitado)) {
        tablero[x_solicitado][y_solicitado] = tablero[x_actual][y_actual].getContenido();
        tablero[x_actual][y_actual].setCasillaVacia();
      } else {

      }
    }
    */
    int filas = 8;
    int columnas = 8;
    this.tablero = new Tablero(filas,columnas);
 }

 public  boolean elJuegoHaTerminado() {

 }

 public  string guardarPartida() {

 }

 public  PartidaAbstracta cargarPartida(string partida) {

 }
 /*----------------- Propios de Chaturanga*/
 public  void desplegarInstrucciones() {

 }
}