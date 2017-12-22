package Dominio;

import Persistencia.GestorUsuarios;

public class Usuario {
	protected String Nick;
	protected String Password;
	protected GestorUsuarios gestorUsuarios;
	
	public Usuario (String Nick, String Password){
		this.Nick=Nick;
		this.Password=Password;
		gestorUsuarios = new GestorUsuarios();
	}

	public String getNick() {
		return Nick;
	}

	public void setNick(String nick) {
		Nick = nick;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public GestorUsuarios getGestorUsuarios() {
		return gestorUsuarios;
	}

	public void setGestorUsuarios(GestorUsuarios gestorUsuarios) {
		this.gestorUsuarios = gestorUsuarios;
	}

	@Override
	public String toString() {
		return "Usuario [Nick=" + Nick + ", Password=" + Password + "]";
	}
	
	
}
