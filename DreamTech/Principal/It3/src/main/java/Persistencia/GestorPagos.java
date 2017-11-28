package Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dominio.PayPal;

public class GestorPagos {
	private Agente agenteBD;
	private List<PayPal> paypals;
	
	public GestorPagos() {
		paypals = new ArrayList<>();
		agenteBD = Agente.getAgente();
	}
	
	public PayPal read(int ID) throws SQLException {
		String sql = "SELECT * FROM usuarios WHERE Nick = '"+ID+"';";
		String Usuario = null;
		double Saldo = 0;
		PayPal paypal;
		ResultSet rs;
		
		rs = agenteBD.read(sql);
		
		if (rs.next()) {
			ID = rs.getInt("ID");
			Usuario = rs.getString("Usuario");
			Saldo = rs.getDouble("Saldo");
		}
		
		paypal = new PayPal(ID,Usuario,Saldo);
	}
	
	public List<PayPal> readAll() throws SQLException {
		String sql = "SELECT * FROM usuarios";
		String Nick = null, Nombre = null, Email = null, Password = null;
		ResultSet rs;
		
		rs = agenteBD.read(sql);
		
		while(rs.next()) {
			Nick = rs.getString("Nick");
			Nombre = rs.getString("Nombre");
			Email = rs.getString("Email");
			Password = rs.getString("Password");
			usuarios.add(new Usuario(Nick, Nombre, Email, Password));
		}
		
		return usuarios;
	}
	
	public int insert(Usuario u) throws SQLException{
		String sql = "INSERT INTO usuarios(Nick,Nombre,Email,Password) VALUES(?,?,?,?)";
		PreparedStatement pst = agenteBD.getConection().prepareStatement(sql);
		pst.setString(1, u.getNick());
		pst.setString(2, u.getNombre());
		pst.setString(3, u.getEmail());
		pst.setString(4, u.getPassword());
		
		int resultado = agenteBD.insert(pst);
		return resultado;
	}
	
	
	public int delete(Usuario u) throws SQLException{
		String sql = "DELETE FROM usuarios WHERE Nombre="+u.getNick();
		PreparedStatement pst = agenteBD.getConection().prepareStatement(sql);
		int resultado = agenteBD.delete(sql); //MIRAR A VER SI SE BORRAN ASI DE LA BASE DE DATOS PQ NO ESTOY SEGURO
		return resultado;
	}