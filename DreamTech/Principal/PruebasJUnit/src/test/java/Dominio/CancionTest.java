package Dominio;

import Persistencia.GestorCancionesTest;
import Persistencia.GestorUsuariosTest;

public class CancionTest {
	protected String nombre;
	protected boolean comprada;
	protected int precio;
	protected GestorCancionesTest gestorCanciones;
	
	public CancionTest (String nombre, boolean comprada, int precio){
		this.nombre=nombre;
		this.comprada=comprada;
		this.precio=precio;
		gestorCanciones=new GestorCancionesTest();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isComprada() {
		return comprada;
	}

	public void setComprada(boolean comprada) {
		this.comprada = comprada;
	}

	public GestorCancionesTest getGestorCanciones() {
		return gestorCanciones;
	}

	public void setGestorCanciones(GestorCancionesTest gestorCanciones) {
		this.gestorCanciones = gestorCanciones;
	}

	
	
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Cancion [nombre=" + nombre + ", comprada=" + comprada + "]";
	}
	
	
}
