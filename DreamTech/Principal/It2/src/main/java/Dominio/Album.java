package Dominio;

import java.sql.SQLException;
import java.util.List;
import Persistencia.GestorAlbums;
import Persistencia.GestorCanciones;
public class Album {
	
	protected String Nombre;
	protected String Artista;
	protected double Precio;
	protected GestorAlbums gestorAlbums;

	public Album() throws ClassNotFoundException{
		gestorAlbums = new GestorAlbums();
	}
	
	public Album(String Nombre, String Artista, double Precio) throws ClassNotFoundException{
		this.Nombre=Nombre;
		this.Artista=Artista;
		this.Precio=Precio;
		gestorAlbums = new GestorAlbums();
	}
	
	public Album(String Nombre) throws ClassNotFoundException{
		this.Nombre=Nombre;
		gestorAlbums = new GestorAlbums();
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getArtista() {
		return Artista;
	}

	public void setArtista(String artista) {
		Artista = artista;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public GestorAlbums getGestorAlbums() {
		return gestorAlbums;
	}

	public void setGestorAlbums(GestorAlbums gestorAlbums) {
		this.gestorAlbums = gestorAlbums;
	}
}
