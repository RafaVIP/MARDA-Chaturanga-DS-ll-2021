import java.io.*;

public class Lectura
{
    Pieza[][] matriz; 
 
    Lectura() {
        matriz = new Pieza[8][];
        for (int i = 0; i < 8; ++i) {
            matriz[i] = new Pieza[8];
        }
        for(int x =  0; x < 8; ++x) {
            for(int y =  0; y < 8; ++y) {
                matriz[x][y] = null;
            }
        }
    }
    
    public void imprimirTablero() {
        for(int x =  0; x < 8; ++x) {
            System.out.println("Fila: " + x);
            for(int y =  0; y < 8; ++y) {
                matriz[x][y].imprimirPieza();
            }
        }
    }
    
    public void cargarPartida(String direccion) {
        try {
                BufferedReader bf = new BufferedReader(new FileReader(direccion));
                String tipo = null;
                String color = null;
                String tmp = null;
                for(int x =  0; x < 8; ++x) {
                    // System.out.println("Fila: " + x);
                    for(int y =  0; y < 8; ++y) {
                        tipo = bf.readLine();
                        color = bf.readLine();
                        // System.out.print("\t" + tipo + " " + color + " " + x + " " + y + "\n");
                        matriz[x][y] = new Pieza(tipo, color, x, y);
                    }
                    tmp = bf.readLine();
                    // System.out.println(tmp);
                }        
                bf.close();
        } catch (Exception e) { System.out.println("Error en lectura de la partida"); }
    }
    
    public void guardarPartida(String direccion) {
        try {
                FileWriter fw = new FileWriter(direccion);
                for(int x =  0; x < 8; ++x) {
                    for(int y =  0; y < 8; ++y) {
                        fw.write(matriz[x][y].getTipo() + "\n" + matriz[x][y].getColor() + "\n");
                    }
                    fw.write("\n");
                }
                fw.close();
        } catch (Exception e) { System.out.println("Error en el guardado de la partida"); }
    }

    public static void main(String[] args) {
                Lectura l = new Lectura();
                l.cargarPartida("C:\\Users\\fabia\\OneDrive\\Escritorio\\Semestre 8\\inicio.txt");
                l.imprimirTablero();
                l.guardarPartida("C:\\Users\\fabia\\OneDrive\\Escritorio\\Semestre 8\\probadura.txt");
    }
}
