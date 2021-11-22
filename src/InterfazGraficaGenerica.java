
/**
 ** Primera iteración Proyecto Programado: Diseño Rafael Porras (B75915) Fabian
 * Gonzalez (B83493) Kevin Salas (B87161) Wendy Ortiz (B75594)
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
    ImageIcon imagen = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(75, 75, 75));
    matrix[ejeY][ejeX].setIcon(imagen);
  }

  /**
   * Método encargado de abrir una nueva interfaz
   * 
   * @param title
   */
  public void abrirNuevaInterfaz(String title) {

    this.setSize(655, 670);
    this.setTitle(title);
    this.setLocationRelativeTo(null);
    this.panel = new JPanel();
    panel.addMouseListener(new MouseAdapter() {
      @Override // I override only one method for presentation
      public void mousePressed(MouseEvent e) {
        partida.enviarCoordenadasMouse(e.getX(), e.getY());
      }
    });
    this.getContentPane().add(this.panel);
    this.panel.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

    inicializarInterfazGrafica();
  }

  /**
   * Metodo encragado de inicializar la interfaz Grafica
   */
  public void inicializarInterfazGrafica() {
    matrix = new JLabel[fila][columna];
    int ejex = 20;
    int ejey = 25;
    for (int x = 0; x < fila; x++) {
      for (int y = 0; y < matrix[x].length; y++) {
        matrix[x][y] = new JLabel();
        matrix[x][y].setBackground(Color.decode("#d1a456"));
        matrix[x][y].setOpaque(true);
        matrix[x][y].setBounds(ejex, ejey, 72, 72);
        panel.add(matrix[x][y]);
        ejex += 75;
      }
      ejex = 20;
      ejey += 75;
    }

    panel.revalidate();
    panel.repaint();
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
    this.panel.revalidate();
    this.panel.repaint();
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

  /**
   * Metodo encargado de borrar un Icon en el tablero
   * 
   * @param fila
   * @param columna
   */
  public void borrarIcon(int fila, int columna) {
    matrix[fila][columna].setIcon(null);
  }

  /**
   * Metodo encargado de pintar la casilla seleccionada en la interfaz grafica
   * 
   * @param fila
   * @param columna
   */
  public void pintarCasillaSeleccionada(int fila, int columna) {
    matrix[fila][columna].setBackground(Color.green);
  }

  /**
   * Metodo encargado de pintar el posible movimiento
   * 
   * @param fila
   * @param columna
   */
  public void pintarmovimiento(int fila, int columna) {
    matrix[fila][columna].setBackground(Color.orange);
  }

  /**
   * Metodo encargado de borrar un Movimiento en la interfaz
   * 
   * @param fila
   * @param columna
   */
  public void borraMovimiento(int fila, int columna) {
    matrix[fila][columna].setBackground(Color.decode("#d1a456"));
  }
}