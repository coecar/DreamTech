package Persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Dominio.Cancion;
import Dominio.Usuario;

public class GestorCancionesTest {
	
	public Cancion[] leerCanciones() throws IOException{
		File archivo = new File ("./canciones.txt");
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		boolean comparadaBoolean;
		
		int numCanciones = Integer.parseInt(br.readLine());
		Cancion[] canciones = new Cancion[numCanciones];
		
		for(int i=0; i<numCanciones;i++){
			String nombre = br.readLine();
			String comprada = br.readLine();	
			if(comprada.equals("true")){
				comparadaBoolean=true;
			}else{
				comparadaBoolean=false;
			}
			String precio = br.readLine();
			int Precio = Integer.parseInt(precio);
			Cancion cancion = new Cancion(nombre,comparadaBoolean,Precio);
			canciones[i]=cancion;
		}
		return canciones;
		
	}
	
	public boolean reproducir(){
		return true;
	}

	public boolean pausar() {
		return false;
	}
	
	public int conseguirPrecio(Cancion cancion){
		return cancion.getPrecio();
	}
	
	public boolean comprarCancion(Usuario u, Cancion c){
		boolean comprada=false;
		GestorUsuariosTest gu = new GestorUsuariosTest();
		int resto=gu.comprarCanciones(c, u);
		if(resto>=0){
			c.setComprada(true);
		}
		return comprada;
	}
}
