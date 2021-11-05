
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

  /// Constructor
  public InterfazGraficaGenerica() {
  }

  /// Constructor
  public InterfazGraficaGenerica(String title) {
    abrirNuevaInterfaz(title);
  }

  /**
   * @Brief Método encargado de imprimir una imagen en el tablero
   * @param filePath
   * @param ejeX
   * @param ejeY
   */
  public void printImage(String filePath, final int ejeX, final int ejeY) {
     System.out.println(filePath);
     String elefante = "imgs/Elefante_verde.png";
     // ImageIcon imagen = new ImageIcon(new ImageIcon("imgs/Elefante_verde.png").getImage().getScaledInstance(45, 45, 45));
    ImageIcon imagen = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(75, 75, 75));
    JLabel label = new JLabel();
    label.setBackground(Color.GREEN);
    label.setIcon(imagen);
    label.setOpaque(false);
    this.panel.setBackground(Color.darkGray);
    label.setLayout(null);
    label.setBounds(ejeX, ejeY, 72, 72);

    this.panel.add(label);
  }

  /**
   * @brief Método encargado de abrir una nueva interfaz
   * @param title
   */
  public void abrirNuevaInterfaz(String title) {

    this.setSize(800, 800);
    this.setTitle(title);
    // this.add(btn);
    this.setLocationRelativeTo(null);
    this.panel = new JPanel();
    this.getContentPane().add(this.panel);
    this.panel.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    // ---------------
  }

  /**
   * @brief Método encargado de agregar in botón en la interfaz
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
   * @brief Método encargado de mostar un mensaje
   * @param parentComponent
   * @param texto
   */
  public void mostrarCuadroDialogo(Component parentComponent, String texto) {
    JOptionPane.showMessageDialog(parentComponent, texto);
  }

}