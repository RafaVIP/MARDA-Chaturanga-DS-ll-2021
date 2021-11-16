
/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161)
 ** Wendy Ortiz (B75594)
 **/

import java.awt.Color;

//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Component;

public class InterfazGraficaGenerica extends JFrame {
  /// Atributos de la clase
  JPanel panel;
  PartidaAbstracta partida;
  JLabel label;
  int cordenadaSeleccionadaX = 0;
  int cordenadaSeleccionadaY = 0;
  boolean seleccionada = false;
  JLabel[][] matrix;

  /// Constructor
  public InterfazGraficaGenerica() {
  }

  /// Constructor
  public InterfazGraficaGenerica(String title, PartidaAbstracta partida) {
    abrirNuevaInterfaz(title);
    this.partida = partida;
  }

  /**
   * Método encargado de imprimir una imagen en el tablero
   * 
   * @param filePath
   * @param ejeX
   * @param ejeY
   *
   */
  public void printImage(String filePath, final int ejeX, final int ejeY) {
    ImageIcon imagen = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(75, 75, 75));
    matrix = new JLabel[8][8];
    int x = 0;
    int y = 0;
    for (x = 0; x < matrix.length; x++) {
      for (y = 0; y < matrix[x].length; y++) {
        matrix[x][y] = new JLabel();
        matrix[x][y].setBounds(ejeX, ejeY, 72, 72);
        matrix[x][y].setOpaque(false);
        matrix[x][y].setIcon(imagen);
        this.panel.add(matrix[x][y]);
      }
    }
    panel.revalidate();
    panel.repaint();
  }

  public void pintarCasilla(int ejeX, int ejeY) {
    //panel.remove(this.matrix[ejeX][ejeY]);

    matrix[ejeX][ejeY].setOpaque(true);
    matrix[ejeX][ejeY].setIcon(null);
    matrix[ejeX][ejeY].setBackground(Color.blue);
    ImageIcon img222 = new ImageIcon(new ImageIcon("imgs/Barco_amarillo.png").getImage().getScaledInstance(75, 75, 75));
    matrix[ejeX][ejeY].setIcon(img222);
    matrix[ejeX][ejeY].setBounds((ejeX*75)+5+75, (ejeY*75)+25, 72, 72);
    this.panel.add(matrix[ejeX][ejeY]);
    
    panel.revalidate();
    panel.repaint();
  }

  /**
   * Método encargado de abrir una nueva interfaz
   * 
   * @param title
   */
  public void abrirNuevaInterfaz(String title) {
    this.setSize(800, 670);
    this.setTitle(title);
    this.setLocationRelativeTo(null);
    this.panel = new JPanel();
  
    // Este metodo sirve para ver cual casilla se clickea
    panel.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        partida.enviarCoordenadasMouse(e.getX(), e.getY());
      }
    });

    this.getContentPane().add(this.panel);
    this.panel.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  /**
   * Método encargado de agregar in botón en la interfaz
   * 
   * @param texto
   * @param action
   * @param ejeX
   * @param ejeY
   */
  public void agregarBoton(String texto, ActionListener action, int ejeX, int ejeY) {
    JButton boton = new JButton(texto);
    boton.setBounds(ejeX, ejeY, 50, 50);
    boton.setSize(100, 20);
    boton.setBackground(Color.LIGHT_GRAY);
    boton.addActionListener(action);
    this.panel.add(boton);
  }

  /**
   * Método encargado de mostar un mensaje
   * 
   * @param parentComponent
   * @param texto
   */
  public void mostrarCuadroDialogo(Component parentComponent, String texto) {
    JOptionPane.showMessageDialog(parentComponent, texto);
  }

}