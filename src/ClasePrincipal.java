
public class ClasePrincipal {

	public static void main(String[] args) {
		boolean continu = true;
		while (continu) {
			int opcion = EntradaSalida.pedirOpcion();
			switch (opcion) {
			case EntradaSalida.BUSCARPALABRA:
				
				break;
			case EntradaSalida.LISTARPALABRAS:
				break;
			case EntradaSalida.VOLCARDATOS:
				break;
			case EntradaSalida.SALIR:
				continu=false;
				break;
			default:
				System.out.println("Introduce una opcion valida");
				break;
			}
		}

	}

}
