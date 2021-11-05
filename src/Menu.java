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
		int opcion = 1;
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
		partida.iniciarPartida();
	}

	/**
	 * Metodo encargado de cargar una partida anterior
	 */
	public void cargarPartida() {
		/* Buscar archivo que toque cargar, jalar el nombre */
		String filePath = "filepath";
		PartidaAbstracta partida = new Chaturanga(filePath);
		partida.iniciarPartida();
	}
}
