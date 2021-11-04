
public class Menu{

	public static void main(String [] args){
		Menu menu = new Menu();
		menu.desplegarMenuPrincipal();
	}

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

	public void crearNuevaPartida() {
		PartidaAbstracta partida = new Chaturanga();
		partida.iniciarPartida();
	}

	public void cargarPartida() {
		/*Buscar archivo que toque cargar, jalar el nombre*/
		String filePath = "filepath";
		PartidaAbstracta partida = new Chaturanga(filePath);
		partida.iniciarPartida();
	}
 }

