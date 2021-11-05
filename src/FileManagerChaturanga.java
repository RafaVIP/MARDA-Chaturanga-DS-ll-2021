
/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161)
 ** Wendy Ortiz (B75594)
 **/

import java.io.FileWriter;
import java.io.*;

public class FileManagerChaturanga extends FileManagerDePartidasAbstracto {
    /**
     * TODO: Guardar todos los archivos generados en alguna carpeta para que no
     * quede todo junto con los archivos .java
     */

    /// atributos de la clase

    /** Archivo donde se encuentran los nombres de las partidas guardadas */
    final String PARTIDAS_PATH = "src/Partidas_guardadas.txt";
    /// Formato base para el nombre del archivo a guardar
    final String BASE_PATH = "src/PartidaChaturanga_";

    /**
     * Metodo encargado de cargar una partida desde un .txt
     * @param filepath dirección donde se encuentra el .txt
     * @return PartidaAbstracta Crea una partida nueva
     */
    public PartidaAbstracta cargarPartida(String filepath) {
        PartidaAbstracta partida = new Chaturanga();

        return partida;
    }

    /**
     * Metodo encargado de guardar la partida actual
     * @param partida Recibe la partida actual
     * @return true si la partida se guardo correctamente
     */
    public boolean guardarPartida(PartidaAbstracta partida) {
        try {
            // Guarda archivo con las partidas guardadas
            String filename = getFilename();
            FileWriter fw = new FileWriter(filename);
            fw.write(partida.to_String());
            fw.close();
            System.out.println("Guarda " + filename + " en el de archivos");
            // Guarda el nombre del archivo en el archivo que contiene las partidas
            // guardadas
            fw = new FileWriter(PARTIDAS_PATH, true);
            fw.write(filename + "\n");
            fw.close();

            return true;
        } catch (Exception e) {
            System.out.println("Error en el guardado de la partida");
            return false;
        }
    }

    /**
     * Busca en los archivos el nombre que deberia tener la partida guardada
     * @return String con el nombre del archivo
     */
    public String getFilename() {
        String filename = "";
        /**
         * Debe contar la cantidad de partidas guardadas y devolver el numero para poder
         * asignar el nombre al file
         */
        int partidasGuardadas = getIdentifierNumber();
        filename = BASE_PATH + partidasGuardadas++;
        return filename;
    }

    /**
     * Metodo encargado de obtener el numero de identificador del archivo
     * @return int (el identificador del archivo)
     */
    public int getIdentifierNumber() {
        int id = 0;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(PARTIDAS_PATH));
            while ((bf.readLine()) != null) {
                id++;
            }
            bf.close();
        } catch (Exception e) {
            System.out.println("Error en lectura del archivo");
        }
        return id;
    }

    /**
     * Metodo encargado de leer el archivo
     * @param filepath la ubicación del archivo
     */
    public String readFile(String filepath) {
        String content = "";
        String line = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filepath));
            while ((line = bf.readLine()) != null) {
                content += line + "\n";
            }
            bf.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error en lectura del archivo");
        }
        return content;
    }
}
