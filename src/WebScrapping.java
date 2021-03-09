import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebScrapping {

	public static Palabra buscarPalabra(String nombre) {
		Palabra p = new Palabra();
		p.setNombre(nombre);
		Document definicion;
		Document imagen;
		try {
			definicion = Jsoup.connect("https://dle.rae.es/"+nombre).get();
			imagen = Jsoup.connect("https://www.google.com/search?safe=active&tbm=isch&q="+nombre).get();
			Elements def = definicion.getElementsByClass("j");
			Elements img = imagen.getElementsByClass("rg_i Q4LuWd");
			p.setDefinicion(def.get(0).text());
			p.setImagen(img.get(img.size()-1).absUrl("data-src"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
		}

}
