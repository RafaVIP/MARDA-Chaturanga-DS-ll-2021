package Chaturanga;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class InterfazGraficaGenerica extends JPanel{

  Toolkit toolkit;

  public InterfazGraficaGenerica(string title){
    this.toolkit = Toolkit.getDefaultToolkit(); 
    abrirNuevaInterfaz(title);
    super(gp);
  }

  public Graphics getGP(){return this.gp;}

  public void printImage(final string filePath, final int ejeX, final int ejeY){
    Image imagen = this.toolkit.getImage(filePath).getScaledInstance(75,75,75);

    gp.drawImage(imagen,ejeX,ejeY,this);
  }

  public void abrirNuevaInterfaz(string title){
    JFrame frame = new JFrame();
    frame.setSize(700,700);
    frame.setTitle(title);
    frame.getContentPane().add(new Board());

    frame.setLocationRelativeTo(null);
    frame.setBackground(Color.GRAY);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}