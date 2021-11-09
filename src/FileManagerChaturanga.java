import java.util.ArrayList;

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
     * @return Retorna el jugador actual ddentro del archivo
     */
    public int cargarJugadorActual(String filepath) {
        int jugador_actual = 0;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filepath));
            jugador_actual =  Integer.parseInt(bf.readLine());
            System.out.println("Jugador actual: " + jugador_actual);
            bf.close();
        } catch (Exception e) { System.out.println("Error en lectura del tablero"); }
        return jugador_actual;
    }
    
    /**
     * Metodo encargado de cargar una partida desde un .txt
     * @param filepath dirección donde se encuentra el .txt
     * @return PartidaAbstracta Crea una partida nueva
     */
    public JugadorAbstracto[] cargarJugadores(String filepath) {
        JugadorAbstracto[] jugadores = new JugadorChaturanga[4]; /*
        ArrayList<String> colores = new ArrayList<String>();
        colores.add("blanco");
        colores.add("verde");
        colores.add("amarillo");
        colores.add("rojo");
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = new JugadorChaturanga(colores);
            String colorElegido = jugadores[i].getColor();
            for (int iterador = 0; iterador < colores.size(); iterador++) {
                if (colores.get(iterador) == colorElegido) {
                  /// permite que el jugador no escoja un color repetido
                  colores.remove(iterador);
                  iterador = colores.size();
                }
            }
        }
        */
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filepath));
            String nombre = "";
            String color = "";
            int numero_piezas_perdidas = 0;
            String pieza_perdida = "";
            // Se salta las casillas de numero de jugadores y las casillas
            for(int i = 0; i < 137; ++i) { 
                bf.readLine();
            }
            for (int jugador_actual = 0; jugador_actual < 4; ++jugador_actual){
                nombre = bf.readLine();
                color = bf.readLine();
                // TODO: crear jugadores con lo que se lee
                numero_piezas_perdidas = Integer.parseInt(bf.readLine());
                System.out.println("Nombre color piezas_perdidas\n" + nombre + " " + color + " " + numero_piezas_perdidas);
                for (int columna = 0; columna < numero_piezas_perdidas; columna++) {
                    pieza_perdida = bf.readLine();
                    System.out.println(pieza_perdida);
                    // TODO: crear piezas con lo que lee
                }
            }
            bf.close();
        } catch (Exception e) { System.out.println("Error en lectura de los jugadores"); }
        return jugadores;
    }

    /**
     * Metodo encargado de cargar una partida desde un .txt
     * @param filepath dirección donde se encuentra el .txt
     * @return PartidaAbstracta Crea una partida nueva
     */
    public Tablero cargarTablero(String filepath) {
        Casilla[][] tablero = new Casilla[8][8];
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filepath));
            String tipo = "";
            String color = "";
            // Setea Casillas  
            // Se salta la linea donde se encuentra el jugador actual
            bf.readLine();
            for (int fila = 0; fila < 8; fila++){
              for (int columna = 0; columna < 8; columna++) {
                tablero[fila][columna] = new Casilla(fila, columna);
                tipo = bf.readLine();
                color = bf.readLine();
                PiezaAbstracta pieza = crearPiezaAbstracta(tipo, color);
                tablero[fila][columna].setContenido(pieza);
              }
              bf.readLine();
            }
            bf.close();
        } catch (Exception e) { System.out.println("Error en lectura del tablero"); }
        return new Tablero(tablero, 8, 8);
    }

    /**
    * Crea una pieza abstracta distinta
    * @param tipo Tipo de pieza
    * @param color Color de la pieza
    * @return La pieza creada a partir de los 2 parametros
    */
    private PiezaAbstracta crearPiezaAbstracta(final String tipo, final String color) {
        if(tipo.equals("rey")) {
          return new Rey(color);
        }
        if(tipo.equals("elefante")) {
          return new Elefante(color);
        }
        if(tipo.equals("barco")) {
          return new Barco(color);
        }
        if(tipo.equals("caballo")) {
          return new Caballo(color);
        }
        if(tipo.equals("peon")) {
          return new Peon(color);
        }
        return null;
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
