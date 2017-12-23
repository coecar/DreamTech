package Persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import Dominio.Cancion;
import Dominio.Usuario;


public class GestorUsuariosTest {
	
	public Usuario[] leerUsuarios() throws IOException{
		File archivo = new File ("./usuarios.txt");
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		
		int numUsuarios = Integer.parseInt(br.readLine());
		Usuario[] usuarios = new Usuario[numUsuarios];
		
		for(int i=0; i<numUsuarios;i++){
			String Nick = br.readLine();
			String Pass = br.readLine();
			String saldo=br.readLine();
			int Saldo=Integer.parseInt(saldo);
			Usuario usuario = new Usuario(Nick,Pass,Saldo);
			usuarios[i]=usuario;
		}
		return usuarios;
		
	}
	
	public boolean logIn(String Nick, String Pass, Usuario[] usuarios) throws IOException{
		boolean logueado = false;
		
		for(int i=0; i<usuarios.length; i++){
			if(usuarios[i].getNick().equals(Nick)){
				if(usuarios[i].getPassword().equals(Pass)){
					logueado=true;
				}
			}
		}
		return logueado;		
	}

	public int conseguirSaldo(String Nick) throws IOException {
		Usuario[] usuarios=leerUsuarios();
		int saldo = 0;
		for(int i=0; i<usuarios.length; i++){
			if(usuarios[i].getNick().equals(Nick)){
				saldo=usuarios[i].getSaldo();
			}
		}
		return saldo;
		
	}
	
	public Usuario devolverUsuario(String Nick) throws IOException{
		Usuario[] usuarios=leerUsuarios();
		String Pass = null;
		int saldo = 0;
		for(int i=0; i<usuarios.length; i++){
			if(usuarios[i].getNick().equals(Nick)){
				Pass = usuarios[i].getPassword();
				saldo = usuarios[i].getSaldo();
			}
		}
		Usuario u = new Usuario(Nick, Pass, saldo);
		return u;
	}
	
	public int comprarCanciones(Cancion c, Usuario u){
		return u.getSaldo()-c.getPrecio();
	}
	
	public Usuario[] cambiarSaldo(Usuario u, int NuevoSaldo) throws IOException{
		Usuario[] usuarios=leerUsuarios();
		for(int i=0; i<usuarios.length; i++){
			if(usuarios[i].getNick().equals(u.getNick())){
				usuarios[i].setSaldo(NuevoSaldo);
			}
		}
		return usuarios;
		
	}

}