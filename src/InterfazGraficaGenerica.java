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
  JPanel panel;

  public InterfazGraficaGenerica() {
  }

  public InterfazGraficaGenerica(String title) {
    abrirNuevaInterfaz(title);
  }

  public void printImage(String filePath, final int ejeX, final int ejeY) {
    System.out.println(filePath);
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

  public void agregarBoton(String texto, ActionListener action, int ejeX, int ejeY) {
    JButton boton = new JButton(texto);
    boton.setBounds(ejeX, ejeY, 50, 50);
    boton.setSize(100, 20);
    boton.setBackground(Color.LIGHT_GRAY);
    boton.addActionListener(action);
    this.panel.add(boton);
  }

  public void mostrarCuadroDialogo(Component parentComponent, String texto) {
    JOptionPane.showMessageDialog(parentComponent, texto);
  }

}