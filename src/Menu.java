/**
 ** Primera iteración Proyecto Programado: Diseño 
 ** Rafael Porras (B75915) 
 ** Fabian Gonzalez (B83493) 
 ** Kevin Salas (B87161)
 ** Wendy Ortiz (B75594)
 **/

public class Menu {

	/**
	 * Metodo principal
	 * @param args
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.desplegarMenuPrincipal();
	}

	/**
	 * Metodo encargado de mostrarles las opciones de menu al usuario
	 */
	public void desplegarMenuPrincipal() {
		System.out.println("Opciones: \n 1. Nueva Partida\n2. Cargar Partida\n3. Salir\n");
		int opcion = 2;
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
			System.out.println("Error\n");
		}
	}

	/**
	 * Metodo encargado de crear una nueva partida
	 */
	public void crearNuevaPartida() {
		PartidaAbstracta partida = new Chaturanga();
		partida.cargarPartida("src/inicio.txt");
		partida.iniciarPartida();
	}

	/**
	 * Metodo encargado de cargar una partida anterior
	 */
	public void cargarPartida() {
	/* Buscar archivo que toque cargar, jalar el nombre */
		// Lee del archivo donde estan las partidas guardadas
		// Mete todo en un arraylist
		// Despliega las opciones en joptionpane
		// Internamente guarda el filepath que se escogio
		String filepath = "src/testing_peon.txt";
		//String filepath = "src/chess.txt";
		PartidaAbstracta partida = new Chaturanga();
		partida.cargarPartida(filepath);
		partida.iniciarPartida();
	}
}
 