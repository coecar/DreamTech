package Dominio;

import Persistencia.GestorAlbums;
/**
 * 
 * @author Miguel de la cal, Carlos Coello, Miguel Ángel García,
 * Werselio Escribano.
 *
 */
public class Album {
	/**
	 * String que almacena el nombre del album.
	 */
	protected String nombre;
	/**
	 * String que almacena el nombre del artista.
	 */
	protected String artista;
	/**
	 * Double que almacena el precio que tiene el album.
	 */
	protected double precio;
	/**
	 * Objeto que apunta al gestor de los albunes.
	 */
	protected GestorAlbums gestorAlbums;
	/**
	 * Metodo constructor para crear un nuevo album.
	 * @throws ClassNotFoundException Excepcion de Clase.
	 */
	public Album() throws ClassNotFoundException{
		gestorAlbums = new GestorAlbums();
	}
	/**
	 * Método constructor para crear un nuevo album.
	 * @param Nombre nombre del album.
	 * @param Artista nombre del artista.
	 * @param Precio precio del album.
	 * @throws ClassNotFoundException Excepcion de Clase.
	 */
	public Album(String Nombre, String Artista, double Precio) throws ClassNotFoundException{
		this.nombre=Nombre;
		this.artista=Artista;
		this.precio=Precio;
		gestorAlbums = new GestorAlbums();
	}
	/**
	 * Método constructor para crear un nuevo album.
	 * @param Nombre nombre del album.
	 * @throws ClassNotFoundException Excepcion de Clase.
	 */
	public Album(String Nombre) throws ClassNotFoundException{
		this.nombre=Nombre;
		gestorAlbums = new GestorAlbums();
	}
	/**
	 * Metodo que devuelve el nombre del album.
	 * @return nombre del album.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo utilizado para cambiar el nombre del album.
	 * @param nombre nombre del album.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que devuelve el artista.
	 * @return nombre del artista.
	 */
	public String getArtista() {
		return artista;
	}
	/**
	 * Metodo que cambia el artista de un album.
	 * @param artista nombre del artista.
	 */
	public void setArtista(String artista) {
		this.artista = artista;
	}
	/**
	 * Metodo que devuelve el precio del album.
	 * @return precio del disco.
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * Metodo utilizado para cambiar el precio del album.
	 * @param precio del disco.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * Metodo que devuelve el gestor. 
	 * @return gestorAlbums devuelve el gestor.
	 */
	public GestorAlbums getGestorAlbums() {
		return gestorAlbums;
	}
	/**
	 * Metodo que asigna el gestor. 
	 * @param gestorAlbums para actualizar dicho gestor.
	 */
	public void setGestorAlbums(GestorAlbums gestorAlbums) {
		this.gestorAlbums = gestorAlbums;
	}
}
