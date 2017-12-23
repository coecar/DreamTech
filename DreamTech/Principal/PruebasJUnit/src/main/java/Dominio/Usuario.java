package Dominio;

import Persistencia.GestorUsuariosTest;

public class Usuario {
	protected String Nick;
	protected String Password;
	protected int saldo;
	protected GestorUsuariosTest gestorUsuarios;
	
	public Usuario (String Nick, String Password, int saldo){
		this.Nick=Nick;
		this.Password=Password;
		this.saldo=saldo;
		gestorUsuarios = new GestorUsuariosTest();
	}

	
	
	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
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

	public GestorUsuariosTest getGestorUsuarios() {
		return gestorUsuarios;
	}
	

	public void setGestorUsuarios(GestorUsuariosTest gestorUsuarios) {
		this.gestorUsuarios = gestorUsuarios;
	}

	@Override
	public String toString() {
		return "Usuario [Nick=" + Nick + ", Password=" + Password + "]";
	}
	
	
}