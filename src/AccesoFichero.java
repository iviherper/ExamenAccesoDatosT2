import java.io.FileWriter;
import java.io.IOException;

public class AccesoFichero {
	public static void crearFichero(String html) {
		try {
			FileWriter fw = new FileWriter("C:\\Users\\Ivi\\Desktop\\palabras.html", false);
			fw.write(html);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
