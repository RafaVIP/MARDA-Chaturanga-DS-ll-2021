
/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161)
 ** Wendy Ortiz (B75594)
 **/

import java.awt.Color;

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
  final int fila = 8;
  final int columna = 8;

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
    ImageIcon imagen = new ImageIcon(new ImageIcon("imgs/Barco_rojo.png").getImage().getScaledInstance(75, 75, 75));
    matrix = new JLabel[fila][columna];
    int ejex = 20;
    int ejey = 25;
    for (int x = 0; x < fila; x++) {
      for (int y = 0; y < matrix[x].length; y++) {

        matrix[x][y] = new JLabel();
        matrix[x][y].setBackground(Color.lightGray);
        matrix[x][y].setOpaque(true);
        matrix[x][y].setBounds(ejex, ejey, 72, 72);
        matrix[0][0].setIcon(imagen);
        panel.add(matrix[x][y]);
        ejex += 75;

        matrix[x][y].addMouseListener(new MouseAdapter() {// provides empty implementation of all
          // MouseListener`s methods, allowing us to
          // override only those which interests us
          @Override // I override only one method for presentation
          public void mousePressed(MouseEvent e) {

            borrarIcon(0, 0);
            pintarIcon("imgs/Barco_rojo.png", 0, 1);
            pintarmovimiento(0, 2);

            matrix[0][1].setIcon(imagen);

          }

        });

      }
      ejex = 20;
      ejey += 75;

    }

    panel.revalidate();
    panel.repaint();
  }

  public void pintarCasilla(int ejeX, int ejeY) {
    // panel.remove(this.matrix[ejeX][ejeY]);

    matrix[ejeX][ejeY].setOpaque(true);
    matrix[ejeX][ejeY].setIcon(null);
    matrix[ejeX][ejeY].setBackground(Color.blue);
    ImageIcon img222 = new ImageIcon(new ImageIcon("imgs/Barco_amarillo.png").getImage().getScaledInstance(75, 75, 75));
    matrix[ejeX][ejeY].setIcon(img222);
    matrix[ejeX][ejeY].setBounds((ejeX * 75) + 5 + 75, (ejeY * 75) + 25, 72, 72);
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

  public void borrarIcon(int fila, int columna) {

    matrix[fila][columna].setIcon(null);
  }

  public void pintarIcon(String filepath, int fila, int columna) {

    ImageIcon imagen = new ImageIcon(new ImageIcon(filepath).getImage().getScaledInstance(75, 75, 75));
    matrix[fila][columna].setIcon(imagen);
  }

  public void pintarmovimiento(int fila, int columna) {

    matrix[fila][columna].setBackground(Color.orange);
  }

  public void Borramovimiento(int fila, int columna) {

    matrix[fila][columna].setBackground(Color.lightGray);
  }

}