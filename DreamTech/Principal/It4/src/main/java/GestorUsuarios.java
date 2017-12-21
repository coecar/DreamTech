import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;


public class GestorUsuarios {
	
	public Usuario[] leerUsuarios() throws IOException{
		File archivo = new File ("./usuarios.txt");
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		
		int numUsuarios = Integer.parseInt(br.readLine());
		Usuario[] usuarios = new Usuario[numUsuarios];
		
		for(int i=0; i<numUsuarios;i++){
			String Nick = br.readLine();
			String Pass = br.readLine();
			
			Usuario usuario = new Usuario(Nick,Pass);
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

}
