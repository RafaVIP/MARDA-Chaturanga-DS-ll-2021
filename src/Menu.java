import java.util.Scanner;
// import Partida;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Menu{
  private InterfazGrafica ventana;
  private Tablero tablero;

	public static void main(String [] args){
		this.desplegarMenuPrincipal();
	}

	public void desplegarMenuPrincipal() {
		ventana = new InterfazGrafica();

		system.out.println("Opciones: \n 1. Nueva Partida\n2. Cargar Partida\n3. Salir\n");
		int opcion = 0;
		switch (opcion) {
			case 1: 
				crearNuevaPartida();
			break;
			case 2:
				cargarPartida();
			break;
			case 3:
				// Nothing
			break;
			default:
			system.out.println("Error\n");
		}
	}

	public void crearNuevaPartida() {
		//to do
		// this.ventana.desplieguePantallaNuevaPartida();
		// this.tablero.empezarNuevaPartida();
	}

	public void cargarPartida() {
		//to do
	}
 }

 public class InterfazGraficaChaturanga extends InterfazGrafica {
	@Override
	public void mostrarJuego() {
		// todo
	}
 }