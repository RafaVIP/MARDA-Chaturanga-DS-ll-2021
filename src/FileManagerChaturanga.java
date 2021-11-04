import java.io.FileWriter;

public class FileManagerChaturanga extends FileManagerDePartidasAbstracto {
    final String BASE_PATH = "PartidaChaturanga_"; // Formato base para el nombre del archivo a guardar
    
    public  PartidaAbstracta cargarPartida() {
        PartidaAbstracta partida = new Chaturanga();

        return partida;
    }

    public  boolean guardarPartida (PartidaAbstracta partida) {
        try {
            FileWriter fw = new FileWriter(getFilename());
            fw.write(partida.to_String());
            fw.close();
            return true;
        }catch(Exception e){
            System.out.println("Error en el guardado de la partida");
            return false;
        }
    }

    /** Busca en los archivos el nombre que deberia tener la partida guardada */
    public String getFilename(){
        String filename = "";
        /** Debe contar la cantidad de partidas guardadas y devolver el numero para poder asignar el nombre al file */
        int partidasGuardadas = 0;
        filename = BASE_PATH + partidasGuardadas++;
        return filename;
    }
}
