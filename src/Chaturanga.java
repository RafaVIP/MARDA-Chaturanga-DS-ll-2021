import java.awt.event.*;
import java.util.ArrayList;

public class Chaturanga extends PartidaAbstracta{
   /*----------------- Propios de Chaturanga*/

  public Chaturanga(){
    this.TOTAL_JUGADORES = 4;
    this.jugadores = new JugadorChaturanga [this.TOTAL_JUGADORES];
    this.jugadorActual = 0;
    asignarColores();
  }
  /**
   * Método encargado de asignar los colores 
   */
  public void asignarColores(){
    ArrayList<String> colores = new ArrayList<String>();

    colores.add("blanco");
    colores.add("verde");
    colores.add("amarillo");
    colores.add("rojo");
  
    for(int i = 0; i < jugadores.length; i++) {
      this.jugadores[i] = new JugadorChaturanga(colores);
      String colorElegido = this.jugadores[i].getColor();
      for(int iterador = 0; iterador< colores.size(); iterador++) {
        if (colores.get(iterador) == colorElegido) {
          System.out.println(colores.get(iterador));
          System.out.println(colorElegido);
          colores.remove(iterador);
          iterador = colores.size();
        }
      }
    }
  // Tablero
  int filas = 8;
  int columnas = 8;
  InterfazGraficaGenerica interfaz = new InterfazGraficaGenerica("Chaturanga");
  
  this.tablero = new Tablero(filas,columnas, interfaz);
  setEstadoInicialDeLasPiezas();
  setElementosDeInterfazIniciales(interfaz);
  this.tablero.imprimirTablero();
}

 public Chaturanga(String filepath){
 
 }

 public void setEstadoInicialDeLasPiezas() {

 }

 public void setElementosDeInterfazIniciales(InterfazGraficaGenerica interfaz){
   /** Agrega el boton de las reglas en la interfaz del juego */
   ActionListener rules = new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent ae){
      FileManagerDePartidasAbstracto fileManager = new FileManagerChaturanga();
      String content = fileManager.readFile("src/rules.txt");
      interfaz.mostrarCuadroDialogo(null,content); // Jalar contenido de txt de las reglas
    }
   };
  interfaz.agregarBoton("Reglas", rules, 0,0);

  /** Guardar Partida*/
  ActionListener guardarPartida = new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent ae){
      guardarPartida();
    }
   };
  interfaz.agregarBoton("Guardar", guardarPartida, 102, 0);
 }
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


 public boolean guardarPartida() {
   FileManagerDePartidasAbstracto fileManager = new FileManagerChaturanga();
  return fileManager.guardarPartida(this);
 }
 
 public boolean elJuegoHaTerminado() {
  return false;
 }
 public  PartidaAbstracta cargarPartida(String filepath) {
  return this;
 }

 /**
    Formato:
    Indice de Jugador actual 
                                        (piezas perdidas)
    Jugador actual 1 : Nombre, Color, [Caballo_verde, Elefante_verde, Peon_verde]
    Jugador actual 2
    Jugador actual 3
    Jugador actual 4

    Fila tablero 1 : [ true{Caballo_verde}, false {}, false {}, false {}, false {}, false {}, false {}, false {},]
    Fila tablero 2
    Fila tablero 3
    Fila tablero 4
    Fila tablero 5
    Fila tablero 6
    Fila tablero 7
    Fila tablero 8
  */
 public String to_String(){
   String chaturanga = "";
   chaturanga += this.jugadorActual + "\n\n";
   // Jugadores
   for (int jugador = 0; jugador < this.TOTAL_JUGADORES; jugador++) {
     chaturanga += this.jugadores[jugador].to_String();
   }
   chaturanga += "\n" + this.tablero.toString();
   return chaturanga;
 }

}