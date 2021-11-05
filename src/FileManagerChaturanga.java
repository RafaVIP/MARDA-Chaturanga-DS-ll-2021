import java.io.FileWriter;
import java.io.*;

public class FileManagerChaturanga extends FileManagerDePartidasAbstracto {
    /**
     * TODO: Guardar todos los archivos generados en alguna carpeta para que no quede todo
     * junto con los archivos .java
     */

    final String PARTIDAS_PATH = "src/Partidas_guardadas.txt"; // Archivo donde se encuentran los nombres de las partidas guardadas
    final String BASE_PATH = "src/PartidaChaturanga_"; // Formato base para el nombre del archivo a guardar
    
    public  PartidaAbstracta cargarPartida(String filepath) {
        PartidaAbstracta partida = new Chaturanga();

        return partida;
    }

    public  boolean guardarPartida (PartidaAbstracta partida) {
        try {
            // Guarda archivo con las partidas guardadas
            String filename = getFilename();
            FileWriter fw = new FileWriter(filename);
            fw.write(partida.to_String());
            fw.close();
            System.out.println("Guarda " + filename + " en el de archivos");
            // Guarda el nombre del archivo en el archivo que contiene las partidas guardadas
            fw = new FileWriter(PARTIDAS_PATH, true);
            fw.write(filename + "\n");
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
        int partidasGuardadas = getidentifierNumber();
        filename = BASE_PATH + partidasGuardadas++;
        return filename;
    }

    public int getidentifierNumber(){
        int id = 0;
        try{
            BufferedReader bf = new BufferedReader(new FileReader(PARTIDAS_PATH));
            while ((bf.readLine()) != null){
                id++;
            }
            bf.close();
        }catch(Exception e){
            System.out.println("Error en lectura del archivo");
        }
        return id;
    }

    public String readFile(String filepath){
        String content = "";
        String line ="";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(filepath));
            while ((line = bf.readLine()) != null){
                content += line + "\n";
            }
            bf.close();
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error en lectura del archivo");
        }
        return content;
    }
}
