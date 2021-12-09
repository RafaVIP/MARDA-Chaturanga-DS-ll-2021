/**
 ** Proyecto Programado: Diseño Rafael Porras (B75915) Fabian
 * Gonzalez (B83493) Kevin Salas (B87161) Wendy Ortiz (B75594)
 **/

import java.util.ArrayList;

public abstract class ReglasPartidaAbstracta {
  /**
   * Comprueba si el jugador contrario puede mover alguna pieza o si ya perdio
   * @param tablero tablero donde para comprobar si quedan jugadas
   * @param jugadorActual jugador actual para determinar de quien es el turno
   * @return Si quedan movimientos, true
   */
  abstract public boolean quedanMovimientos(Casilla[][] tablero, int jugadorActual);

  /**
   * Remueve movimientos que ponen en peligro al rey o que no sigan las reglas de su respectivo juego
   * @param tablero tablero donde para comprobar si quedan jugadas
   * @param jugadorActual jugador actual para determinar de quien es el turno
   * @param movimientos movimientos a filtrar
   * @param x_sel eje x seleccionado
   * @param y_sel eje y seleccionado
   * @param piezaSeleccionada_actual pieza a la que se le consultan sus movimientos
   * @return Si quedan movimientos, true
   */
  abstract public ArrayList<String> filtrarMovimientos(Casilla[][] tablero, int jugadorActual,
   ArrayList<String> movimientos, int x_sel, int y_sel, PiezaAbstracta piezaSeleccionada_actual);
}