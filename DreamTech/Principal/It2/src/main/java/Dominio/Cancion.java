package Dominio;

import java.sql.SQLException;
import java.util.List;
import Persistencia.GestorCanciones;
/**
 * @author Miguel de la cal, Carlos Coello, Miguel Ángel García,
 * Werselio Escribano.
 */
public class Cancion {
	/**
	 * String con el nombre de la cancion.
	 */
	protected String nombre;
	/**
	 * String con el nombre del artista.
	 */
	protected String artista;
	/**
	 * Double con el precio de la cancion. 
	 */
	protected double precio;
	/**
	 * Variable que almacena el gestor.
	 */
	protected GestorCanciones gestorCanciones;
	/**
	 * Metodo constructor.
	 * @throws ClassNotFoundException  Excepcion de Clase.
	 */
	public Cancion() throws ClassNotFoundException {
		gestorCanciones = new GestorCanciones();
	}
	/**
	 * Metodo constructor para la cancion.
	 * @param Nombre de la cancion.
	 * @param Artista nombre del artista.
	 * @param Precio precio de la cancion.
	 * @throws ClassNotFoundException  Excepcion de Clase.
	 */
	public Cancion(String Nombre, String Artista, double Precio) throws ClassNotFoundException {
		this.nombre = Nombre;
		this.artista = Artista;
		this.precio = Precio;
		gestorCanciones = new GestorCanciones();
	}
	/**
	 * Metodo costructor para crear una cancion.
	 * @param Nombre de la cancion.
	 * @throws ClassNotFoundException  Excepcion de Clase.
	 */
	public Cancion(String Nombre) throws ClassNotFoundException {
		this.nombre = Nombre;
		gestorCanciones = new GestorCanciones();
	}
	/**
	 * Metodo usado para devolver el nombre.
	 * @return nombre de la canción.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que se usa para cambiar el nombre de una cancion.
	 * @param nombre de la canción a cambiar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que se usa para obtener el nombre del artista.
	 * @return nombre del artista.
	 */
	public String getArtista() {
		return artista;
	}
	/**
	 * Metodo para cambiar el nombre del artista.
	 * @param artista nombre del artista a cambiar.
	 */
	public void setArtista(String artista) {
		this.artista = artista;
	}
	/**
	 * Metodo para obtener el precio de una cancion.
	 * @return precio de la canción.
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * Metodo para cambiar el precio de una cancion.
	 * @param precio del disco.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * Metodo para devolver canciones.
	 * @return gestorCanciones es el gestor.
	 */
	public GestorCanciones getGestorCanciones() {
		return gestorCanciones;
	}
	/**
	 * Metodo para asginar el gestor.
	 * @param gestorCanciones a asginar al parametro.
	 */
	public void setGestorCanciones(GestorCanciones gestorCanciones) {
		this.gestorCanciones = gestorCanciones;
	}
	/**
	 * Método para leer una canción de la base de datos. 
	 * @return Devuelve el resultado de ejecutar el metodo read del gestor.
	 * @throws SQLException Excepción de base de datos.
	 * @throws ClassNotFoundException  Excepcion de Clase.
	 */
	public Cancion leerCancion() throws SQLException, ClassNotFoundException {
		return gestorCanciones.read(this.getNombre());
	}
	/**
	 * Metodo para leer todos los elementos de la base de datos.
	 * @return Devuelve el resultado de ejecutar el metodo readAll del gestor.
	 * @throws SQLException Excepción de base de datos.
	 * @throws ClassNotFoundException  Excepcion de Clase.
	 */
	public List<Cancion> leerTodos() throws SQLException, ClassNotFoundException {
		return gestorCanciones.readAll();
	}
	/**
	 * Metodo para insertar una canción en la base de datos.s
	 * @return Devuelve el resultado de ejecutar el metodo insert del gestor.
	 * @throws SQLException Excepción de base de datos.
	 */
	public int insertar() throws SQLException {
		return gestorCanciones.insert(this);
	}
}
