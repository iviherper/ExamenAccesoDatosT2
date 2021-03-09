import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
public class AccesoaBD {

		static MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		static DB database = mongoClient.getDB("Examen");
		static DBCollection palabras = database.getCollection("palabras");

		public static void guardarPalabraMongo(Palabra p) {
			DBObject objeto = new BasicDBObject("nombre", p.getNombre()).append("definicion", p.getDefinicion()).append("imagen", p.getImagen());
			palabras.insert(objeto);
		}
		
		public static ArrayList<Palabra> sacarPalabras() {
			ArrayList<Palabra> listaPalabras = new ArrayList<Palabra>();
			Iterable<DBObject> cursor = palabras.find();
			
			for(DBObject dbobject : cursor) {
				Palabra p = new Palabra((String) dbobject.get("nombre"),(String) dbobject.get("definicion"), (String) dbobject.get("imagen"));
				listaPalabras.add(p);
			}
			return listaPalabras;
		}
		
	

}
