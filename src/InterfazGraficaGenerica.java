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

  public Graphics gp;

  Toolkit toolkit;

  public InterfazGraficaGenerica(){
    this.toolkit = Toolkit.getDefaultToolkit(); 
  }

  public Graphics getGP(){return this.gp;}

  public void printImage(final string filePath, final int ejeX, final int ejeY){
    Image imagen = this.toolkit.getImage(filePath).getScaledInstance(75,75,75);

    gp.drawImage(imagen,ejeX,ejeY,this);
  }
}