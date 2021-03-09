import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
		DBObject objeto = new BasicDBObject("nombre", p.getNombre()).append("definicion", p.getDefinicion())
				.append("imagen", p.getImagen());
		palabras.insert(objeto);
	}

	public static ArrayList<Palabra> sacarPalabras() {
		ArrayList<Palabra> listaPalabras = new ArrayList<Palabra>();
		Iterable<DBObject> cursor = palabras.find();

		for (DBObject dbobject : cursor) {
			Palabra p = new Palabra((String) dbobject.get("nombre"), (String) dbobject.get("definicion"),
					(String) dbobject.get("imagen"));
			listaPalabras.add(p);
		}
		return listaPalabras;
	}

	static StandardServiceRegistry s = null;
	static SessionFactory sf = null;
	static Session sesion = null;

	public static void inicializarConexion() {
		s = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(s).buildMetadata().buildSessionFactory();
		sesion = sf.openSession();
	}

	public static void guardarHibernate(Palabra palabra2) {
		inicializarConexion();
		Transaction t = sesion.beginTransaction();
		if (palabra2.getDefinicion().length() >= 255)
			palabra2.setDefinicion(palabra2.getDefinicion().substring(0, 254));
		sesion.save(palabra2);
		t.commit();
	}

}
