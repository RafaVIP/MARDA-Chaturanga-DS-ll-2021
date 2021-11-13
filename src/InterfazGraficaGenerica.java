
/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161)
 ** Wendy Ortiz (B75594)
 **/

import java.awt.Color;

import javax.swing.Icon;
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
    ImageIcon img = new ImageIcon(new ImageIcon("Barco_verde.png").getImage().getScaledInstance(75, 75, 75));
    JLabel[][] matrix = new JLabel[8][8];
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

    matrix[0][2].setOpaque(true);
    matrix[0][2].setIcon(null);
    matrix[0][2].setBackground(Color.green);
    matrix[0][2].setBounds(ejeX, ejeY, 72, 72);

    this.panel.setBackground(Color.darkGray);

    // this.label = new JLabel();
    // label.setBackground(Color.GREEN);
    // label.setIcon(imagen);
    // label.setOpaque(false);
    // this.panel.setBackground(Color.darkGray);
    // label.setLayout(null);
    // label.setBounds(ejeX, ejeY, 75, 75);

    // this.panel.add(matrix);
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
    /*
     * panel.addMouseListener(new MouseAdapter() {// provides empty implementation
     * of all // MouseListener`s methods, allowing us to // override only those
     * which interests us
     * 
     * @Override // I override only one method for presentation public void
     * mousePressed(MouseEvent e) { int x = (e.getX() - 5) / 75; int y = (e.getY() -
     * 25) / 75; System.out.println("Casilla seleccionada: (" + x + "," + y + ")");
     * partida.devuelveContenido(e.getX(), e.getY());
     * 
     * }
     * 
     * });
     */

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