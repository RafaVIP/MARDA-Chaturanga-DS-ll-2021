/**
 * Proyecto Programado: Diseño Rafael Porras (B75915) Fabian
 * Gonzalez (B83493) Kevin Salas (B87161) Wendy Ortiz (B75594)
 **/

public class Menu {

	/**
	 * Metodo principal
	 * 
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
		ControladorPartida partida = new ControladorPartida();
		int opcion = partida.seleccionar_menu();
		switch (opcion) {
		case 0:
			crearNuevaPartida(partida);
			break;
		case 1:
			cargarPartida(partida);
			break;
		default:
			System.out.println("Error\n");
		}
	}

	/**
	 * Metodo encargado de crear una nueva partida
	 * @param partida
	 */
	public void crearNuevaPartida(ControladorPartida partida) {
		partida.cargarPartida("src/inicio.txt");
	}

	/**
	 * Metodo encargado de cargar una partida anterior
	 * @param partida
	 */
	public void cargarPartida(ControladorPartida partida) {
		/* Buscar archivo que toque cargar, jalar el nombre */
		String filepath = partida.seleccionarPartida("src/Partidas_guardadas.txt");
		partida.cargarPartida(filepath);
	}
}
