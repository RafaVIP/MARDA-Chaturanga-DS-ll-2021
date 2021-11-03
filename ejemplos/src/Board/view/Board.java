package Board.view;
package Chatu.model;

import Chatu.model.Pieza;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel {
    // Coordenadas para impresion
    int base = 50;
    int tamano_casilla = 75; 
    // Modificar: i para cambiar fila | y para cambiar numero de columna
    // gp.drawImage(img, base + (tamano_casilla * i), base + (tamano_casilla * y), this);
    private String path = "src/Chatu/images/";
    Toolkit t = Toolkit.getDefaultToolkit();  
    Image img = t.getImage(path + "elefante_verde.png/").getScaledInstance(75, 75, 75);
    // Las imagenes de las piezas rojas
    Image peon_rojo = t.getImage(path + "peon_rojo.png/").getScaledInstance(75, 75, 75);
    Image rey_rojo = t.getImage(path + "rey_rojo.png/").getScaledInstance(75, 75, 75);
    Image elefante_rojo = t.getImage(path + "elefante_rojo.png/").getScaledInstance(75, 75, 75);
    Image barco_rojo = t.getImage(path + "barco_rojo.png/").getScaledInstance(75, 75, 75);
    Image caballo_rojo = t.getImage(path + "caballo_rojo.png/").getScaledInstance(75, 75, 75);
    // Las imagenes de las piezas verdes
    Image peon_verde = t.getImage(path + "peon_verde.png/").getScaledInstance(75, 75, 75);
    Image rey_verde = t.getImage(path + "rey_verde.png/").getScaledInstance(75, 75, 75);
    Image elefante_verde = t.getImage(path + "elefante_verde.png/").getScaledInstance(75, 75, 75);
    Image barco_verde = t.getImage(path + "barco_verde.png/").getScaledInstance(75, 75, 75);
    Image caballo_verde = t.getImage(path + "caballo_verde.png/").getScaledInstance(75, 75, 75);
    // Las imagenes de las piezas amarillas
    Image peon_amarillo = t.getImage(path + "peon_amarillo.png/").getScaledInstance(75, 75, 75);
    Image rey_amarillo = t.getImage(path + "rey_amarillo.png/").getScaledInstance(75, 75, 75);
    Image elefante_amarillo = t.getImage(path + "elefante_amarillo.png/").getScaledInstance(75, 75, 75);
    Image barco_amarillo = t.getImage(path + "barco_amarillo.png/").getScaledInstance(75, 75, 75);
    Image caballo_amarillo = t.getImage(path + "caballo_amarillo.png/").getScaledInstance(75, 75, 75);
    // Las imagenes de las piezas blancas
    Image peon_blanco = t.getImage(path + "peon_blanco.png/").getScaledInstance(75, 75, 75);
    Image rey_blanco = t.getImage(path + "rey_blanco.png/").getScaledInstance(75, 75, 75);
    Image elefante_blanco = t.getImage(path + "elefante_blanco.png/").getScaledInstance(75, 75, 75);
    Image barco_blanco = t.getImage(path + "barco_blanco.png/").getScaledInstance(75, 75, 75);
    Image caballo_blanco = t.getImage(path + "caballo_blanco.png/").getScaledInstance(75, 75, 75);

    public void imprimirPiezasIniciales(Graphics gp) {
        this.imprimirPiezasRojas(gp);
        this.imprimirPiezasVerdes(gp);
        this.imprimirPiezasAmarillas(gp);
        this.imprimirPiezasBlancas(gp);
    }

    public void imprimirPiezasRojas(Graphics gp) {
        for (int row = 0; row < 4; ++row) {
            this.dibujePieza(gp, peon_rojo, row, 6);
        }
        this.dibujePieza(gp, barco_rojo,     0, 7);
        this.dibujePieza(gp, caballo_rojo,   1, 7);
        this.dibujePieza(gp, elefante_rojo,  2, 7);
        this.dibujePieza(gp, rey_rojo,       3, 7);
    }

    public void imprimirPiezasVerdes(Graphics gp) {
        for (int col = 4; col < 8; ++col) {
            this.dibujePieza(gp, peon_verde, 6, col);
        }
        this.dibujePieza(gp, barco_verde,     7, 7);
        this.dibujePieza(gp, caballo_verde,   7, 6);
        this.dibujePieza(gp, elefante_verde,  7, 5);
        this.dibujePieza(gp, rey_verde,       7, 4);
    }

    public void imprimirPiezasAmarillas(Graphics gp) {
        for (int col = 0; col < 4; ++col) {
            this.dibujePieza(gp, peon_amarillo, 1, col);
        }
        this.dibujePieza(gp, barco_amarillo,     0, 0);
        this.dibujePieza(gp, caballo_amarillo,   0, 1);
        this.dibujePieza(gp, elefante_amarillo,  0, 2);
        this.dibujePieza(gp, rey_amarillo,       0, 3);
    }

    public void imprimirPiezasBlancas(Graphics gp) {
        for (int row = 4; row < 8; ++row) {
            this.dibujePieza(gp, peon_blanco, row, 1);
        }
        this.dibujePieza(gp, barco_blanco,     7, 0);
        this.dibujePieza(gp, caballo_blanco,   6, 0);
        this.dibujePieza(gp, elefante_blanco,  5, 0);
        this.dibujePieza(gp, rey_blanco,       4, 0);
    }

    public void dibujePieza(Graphics gp, Image pieza, int fila, int columna) {
        gp.drawImage(pieza, this.base + (this.tamano_casilla * fila), this.base + (this.tamano_casilla * columna), this);
    }
     
    //hacer un vector de imagenes 
    //dar a la imagen un name para cada index y luego crearlas y ponerlas en el tablero
    public void paint(Graphics gp){
        gp.fillRect(50, 50, 600, 600);
        for(int x=50; x<=600;x+=150){
            for(int y=50; y<=600;y+=150){  
                gp.clearRect(x, y, 75, 75);
            }
        }      
       for(int x=125; x<=600;x+=150){
            for(int y=125; y<=600;y+=150){
                gp.clearRect(x, y, 75, 75);
            }
        }
        this.imprimirPiezasIniciales(gp);
    }

    public static void main(String [] args){
        ArrayList<Pieza> piezas = new ArrayList<>();
        // hace el frame de fondo 
        JFrame frame = new JFrame();
        frame.setSize(700,700);
        frame.setTitle("Prueba chess Board");
        frame.getContentPane().add(new Board());
        
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
