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

  public void printImage(final String filePath, final int ejeX, final int ejeY) {

    ImageIcon imagen = new ImageIcon(new ImageIcon("imgs/Elefante_verde.png").getImage().getScaledInstance(45, 45, 45));
    JLabel label = new JLabel();
    label.setBackground(Color.WHITE);
    label.setIcon(imagen);
    label.setOpaque(true);
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
    this.agregarBoton("Reglas", al);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    // ---------------
  }

  public void agregarBoton(String texto, ActionListener action) {
    JButton boton = new JButton(texto);
    boton.setSize(100, 20);
    boton.setBackground(Color.LIGHT_GRAY);
    boton.addActionListener(action);
    this.panel.add(boton);
  }

  public void mostrarCuadroDialogo(Component parentComponent, String texto) {
    JOptionPane.showMessageDialog(parentComponent, texto);
  }


  ActionListener al = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      JOptionPane.showMessageDialog(null,
          "Reglas: \n" + "1. Cada jugador tiene ocho piezas: 1 Rey, 1 Elefante, 1 caballo, 1 Barco y 4 Peones. \n"
              + "2. El barco se mueve en diagonal en cualquier dirección, pero solo puede moverse\n"
              + "3. Los peones pueden avanzar solo en la dirección en la que miran y pueden ascender a \n"
              + "cualquier otro tipo de pieza excepto rey cuando alcanzan el octavo rango.\n"
              + "4. No hay un movimiento doble inicial para los peones.\n"
              + "5. No hay noción de jaque o mate, por lo que se deben tomar reyes para eliminar a un jugador. \n"
              + "6. Las piezas de los jugadores eliminados permanecen en el tablero como obstáculos, \n"
              + "pero no pueden moverse. \n"
              + "7. El juego termina cuando queda un solo rey, ocurre una posición idéntica \n"
              + "tres veces durante el juego, o cada jugador ha realizado al menos 50 movimientos \n"
              + "consecutivos sin mover un peón o capturar una pieza. \n" + ""
              + "8. Un punto se divide en partes iguales entre todos los jugadores con reyes en \n"
              + "el tablero cuando finaliza el juego; cualquier jugador sin rey obtiene una puntuación de 0.\n");
    }
  };

}