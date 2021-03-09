import java.util.Scanner;

public class EntradaSalida {

	public static final int SALIR = 4;
	public static final int VOLCARDATOS = 3;
	public static final int BUSCARPALABRA = 1;
	public static final int LISTARPALABRAS = 2;
	private static Scanner sc = new Scanner(System.in);
	
	public static int pedirOpcion() {
		System.out.println("Introduce una opción:");
		System.out.println("1-Buscar palabra");
		System.out.println("2-Listar palabras");
		System.out.println("3-Volcar datos de MongoDB en MySQL");
		System.out.println("4-Salir");
		int opcion = Integer.parseInt(sc.nextLine());
		return opcion;
	}

}
