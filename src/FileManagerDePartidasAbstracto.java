/**
 ** Primera iteración Proyecto Programado: Diseño Rafael Porras (B75915) Fabian
 * Gonzalez (B83493) Kevin Salas (B87161) Wendy Ortiz (B75594)
 **/

public abstract class FileManagerDePartidasAbstracto {
    /**
     * Metodo encargado de cargar una partida desde un .txt
     * 
     * @param filepath dirección donde se encuentra el .txt
     * @return PartidaAbstracta Crea una partida nueva
     */
    public abstract int cargarJugadorActual(String filepath);

    /**
     * Metodo encargado de cargar una partida desde un .txt
     * 
     * @param filepath dirección donde se encuentra el .txt
     * @return PartidaAbstracta Crea una partida nueva
     */
    public abstract JugadorAbstracto[] cargarJugadores(String filepath);

    /**
     * Metodo encargado de cargar una partida desde un .txt
     * 
     * @param filepath dirección donde se encuentra el .txt
     * @return PartidaAbstracta Crea una partida nueva
     */
    public abstract Tablero cargarTablero(String filepath);

    /**
     * Metodo encargado de guardar la partida actual
     * 
     * @param partida Recibe la partida actual
     * @return true si la partida se guardo correctamente
     */
    public abstract boolean guardarPartida(ControladorPartida partida);

    /**
     * Metodo encargado de leer el archivo
     * 
     * @param filepath la ubicación del archivo
     */
    public abstract String readFile(String filepath);
}
