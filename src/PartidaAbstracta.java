/**
 ** Primera iteración Proyecto Programado: Diseño Rafael Porras (B75915) Fabian
 * Gonzalez (B83493) Kevin Salas (B87161) Wendy Ortiz (B75594)
 **/

public abstract class PartidaAbstracta {
  /// Atributos de la clase
  Tablero tablero;
  JugadorAbstracto[] jugadores;
  int jugadorActual;
  int TOTAL_JUGADORES;

  /**
   * Metodo encargado de verificar que el juego haya terminado
   * 
   * @return true si ya termino
   */
  public abstract boolean elJuegoHaTerminado();

  /**
   * Metodo encargado de guardar una partida en documento de texto
   * 
   * @return true si se guardo correctamente
   */
  public abstract boolean guardarPartida();

  /**
   * Metodo encargado de cargar una partida desde un archivo de texto
   * 
   * @param partida
   * @param filepath
   * @return PartidaAbstracta (la partida que cargo)
   */
  public abstract void cargarPartida(String filepath);

  /**
   * Metodo encargado de convertir a string
   * 
   * @return String convertidp
   */
  public abstract String to_String();

  /**
   * Metodo encargado de enviar las coordenas al mouse
   * @param int
   * @param int
   */
  public abstract void enviarCoordenadasMouse(int cordX, int cordY);

  /**
   * Metodo encargado de seleccionar la partida
   * 
   * @param filepath
   * @return el string con el filepath
   */
  public abstract String seleccionarPartida(String filepath);

  /**
   * metodo encargado de mostrar las opciones para seleccionar en el menu
   * 
   * @return la opcion que se selecciono del menu
   */
  public abstract int seleccionar_menu();
}