import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;

@Entity
public class Palabra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String nombre;
	private String definicion;
	private String imagen;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDefinicion() {
		return definicion;
	}
	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "Palabra [nombre=" + nombre + ", definicion=" + definicion + ", imagen=" + imagen + "]";
	}
	public Palabra() {
		super();
	}
	public Palabra(String nombre, String definicion, String imagen) {
		super();
		this.nombre = nombre;
		this.definicion = definicion;
		this.imagen = imagen;
	}
	
	
}
