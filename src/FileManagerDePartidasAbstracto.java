public abstract class FileManagerDePartidasAbstracto {
    public abstract PartidaAbstracta cargarPartida(String filepath);

    public abstract boolean guardarPartida (PartidaAbstracta partida);

    public abstract String readFile(String filepath);
}
