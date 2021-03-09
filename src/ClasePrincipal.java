import java.util.ArrayList;

public class ClasePrincipal {

	public static void main(String[] args) {
		boolean continu = true;
		while (continu) {
			int opcion = EntradaSalida.pedirOpcion();
			switch (opcion) {
			case EntradaSalida.BUSCARPALABRA:
				String palabra = EntradaSalida.pedirPalabra();
				Palabra p = WebScrapping.buscarPalabra(palabra);
				System.out.println(p);
				AccesoaBD.guardarPalabraMongo(p);
				break;
			case EntradaSalida.LISTARPALABRAS:
				ArrayList<Palabra> palabras = AccesoaBD.sacarPalabras();
				String tabla = PintarHTML.crearHTML(palabras);
				AccesoFichero.crearFichero(tabla);
				Runtime r = Runtime.getRuntime();
				Process pro = null;
				String comando[] = {"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","C:\\Users\\Ivi\\Desktop\\palabras.html"};
				try
				{
				pro = r.exec(comando);
				} catch (Exception e) {}
				break;
			case EntradaSalida.VOLCARDATOS:
				ArrayList<Palabra> palabrass = AccesoaBD.sacarPalabras();
				for (Palabra palabra2 : palabrass) {
					AccesoaBD.guardarHibernate(palabra2);
				}
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
