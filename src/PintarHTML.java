import java.util.ArrayList;

public class PintarHTML {

	public static String crearHTML(ArrayList<Palabra> palabras) {
		String html="<html><head><title>Examen T2</title></head><body><table><tr><th>Nombre</th><th>Definicion</th><th>Imagen</th></tr>";
		for (Palabra palabra : palabras) {
			html+="<tr><td>"+palabra.getNombre()+"</td><td>"+palabra.getDefinicion()+"</td><td><img src='"+palabra.getImagen()+"'></td></tr>";
		}
		html+="</table></body></html>";
		return html;
	}

}
