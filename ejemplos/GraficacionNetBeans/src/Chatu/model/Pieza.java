/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chatu.model;

import java.util.ArrayList;

/**
 *
 * @author HomePC
 */
public class Pieza {

  
    int row;
    int colum;
    String color;
    String tipo;
    ArrayList<Pieza> piezas;
      public Pieza(int row, int colum, String color,String tipo,ArrayList<Pieza> piezas) {
        this.row = row;
        this.colum = colum;
        this.color = color;
        this.piezas=piezas;
        this.tipo=tipo;
        piezas.add(this);
    }

    public Pieza(int i, int i0, String verde, String barco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void movimiento(int row, int col){
    
     for(Pieza p: piezas){
     
          if(p.row==row && p.colum==col){
          
              p.muerta();
             
          }
     }
      this.row=row;
      this.colum=col;
    }
    
    public void muerta(){
    
     piezas.remove(this);
    
    }
    
    
}
