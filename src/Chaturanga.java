import java.awt.event.*;
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
 }

 public boolean elJuegoHaTerminado() {
  return false;
 }

 public String guardarPartida() {
  return "";
 }

 public  PartidaAbstracta cargarPartida(String partida) {
  return this;
 }
 /*----------------- Propios de Chaturanga*/

 public Chaturanga(){
  int filas = 8;
  int columnas = 8;
  InterfazGraficaGenerica interfaz = new InterfazGraficaGenerica("Chaturanga");
  
  this.tablero = new Tablero(filas,columnas, interfaz);
  setEstadoInicialDeLasPiezas();
  setElementosDeInterfazIniciales(interfaz);
  this.tablero.imprimirTablero();
}

 public Chaturanga(String tittle){
 
 }

 public void setEstadoInicialDeLasPiezas() {

 }

 public void setElementosDeInterfazIniciales(InterfazGraficaGenerica interfaz){
   /** Agrega el boton de las reglas en la interfaz del juego */
   ActionListener rules = new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent ae){
      interfaz.mostrarCuadroDialogo(null,"hola mundo"); // Jalar contenido de txt de las reglas
    }
   };
  interfaz.agregarBoton("Reglas", rules);

  /** Guardar Partida*/
  ActionListener guardarPartida = new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent ae){
      guardarPartida();
    }
   };
  interfaz.agregarBoton("Guardar partida", guardarPartida);
 }

}