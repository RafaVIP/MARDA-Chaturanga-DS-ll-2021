
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.*;
import java.awt.Component;


public class InterfazGraficaGenerica extends JFrame{
  JPanel panel;

  public InterfazGraficaGenerica(){
  }
  public InterfazGraficaGenerica(String title){
    abrirNuevaInterfaz(title);
  }

  public void printImage(final String filePath, final int ejeX, final int ejeY){
    ImageIcon imagen = new ImageIcon(filePath);
    JLabel label = new JLabel(new ImageIcon(imagen.getImage().getScaledInstance(75,75,Image.SCALE_SMOOTH)));
    this.panel.setBackground(Color.DARK_GRAY);
    label.setOpaque(true);
    label.setLayout(null);
    label.setBounds(ejeX, ejeY, 25, 25);
    this.panel.add(label);
  }

  public void abrirNuevaInterfaz(String title){
    this.setSize(700,700);
    this.setTitle(title);
    this.setLocationRelativeTo(null);
    this.panel = new JPanel();
    this.getContentPane().add(this.panel);
    this.panel.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    // ---------------
  }

  public void agregarBoton(String texto, ActionListener action){
    JButton boton = new JButton(texto);
    boton.addActionListener(action);
    this.panel.add(boton);
  }

  public void mostrarCuadroDialogo(Component parentComponent, String texto){
    JOptionPane.showMessageDialog(parentComponent, texto); 
  }
}