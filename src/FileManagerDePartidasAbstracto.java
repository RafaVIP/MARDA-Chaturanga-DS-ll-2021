/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161)
 ** Wendy Ortiz (B75594)
 **/

public abstract class FileManagerDePartidasAbstracto {
    /**
     * @brief Metodo encargado de cargar una partida desde un .txt
     * @param filepath dirección donde se encuentra el .txt
     * @return PartidaAbstracta Crea una partida nueva
     */
    public abstract PartidaAbstracta cargarPartida(String filepath);

    /**
     * @brief Metodo encargado de guardar la partida actual
     * @param partida Recibe la partida actual
     * @return true si la partida se guardo correctamente
     */
    public abstract boolean guardarPartida(PartidaAbstracta partida);

    /**
     * @brief Metodo encargado de leer el archivo
     * @param filepath la ubicación del archivo
     */
    public abstract String readFile(String filepath);
}
