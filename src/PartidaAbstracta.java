public abstract class PartidaAbstracta {
  Tablero tablero;
  JugadorAbstracto [] jugadores;
  int jugadorActual;
  int TOTAL_JUGADORES;
  
  public abstract void iniciarPartida();

  public abstract boolean elJuegoHaTerminado();

  public abstract boolean guardarPartida();

  public abstract PartidaAbstracta cargarPartida(String partida);

  public abstract String to_String();

}