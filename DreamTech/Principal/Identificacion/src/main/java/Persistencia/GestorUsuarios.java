package Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dominio.Usuario;

public class GestorUsuarios {
	private Agente agenteBD;
	private List<Usuario> usuarios;
	
	public GestorUsuarios() {
		usuarios = new ArrayList<>();
		agenteBD = Agente.getAgente();
	}
	
	public Usuario read(String Nick) throws SQLException {
		String sql = "SELECT * FROM usuarios WHERE Nick = '"+Nick+"';";
		String Nombre = null, Apellido = null, Password = null;
		int id=0;
		Usuario usuario;
		ResultSet rs;
		
		rs = agenteBD.read(sql);
		
		if (rs.next()) {
			Nick = rs.getString("Nick");
			Nombre = rs.getString("Nombre");
			Password = rs.getString("Password");
			Apellido = rs.getString("Apellido");
		}
		
		usuario = new Usuario(Nick, Nombre, Apellido,Password);
		if (usuario.getPassword()==null){
			return null;
		} else {
		return usuario;
		}
	}
	
	public List<Usuario> readAll() throws SQLException {
		String sql = "SELECT * FROM usuarios";
		String Nick = null, Nombre = null, Apellido = null, Password = null;
		ResultSet rs;
		
		rs = agenteBD.read(sql);
		
		while(rs.next()) {
			Nick = rs.getString("Nick");
			Nombre = rs.getString("Nombre");
			Apellido = rs.getString("Apellido");
			Password = rs.getString("Password");
			usuarios.add(new Usuario(Nick, Nombre, Apellido, Password));
		}
		
		return usuarios;
	}
	
	public int insert(Usuario u) throws SQLException{
		String sql = "INSERT INTO usuarios(Nick,Nombre,Apellido,Password) VALUES(?,?,?,?)";
		PreparedStatement pst = agenteBD.getConection().prepareStatement(sql);
		pst.setString(1, u.getNick());
		pst.setString(2, u.getNombre());
		pst.setString(3, u.getApellido());
		pst.setString(4, u.getPassword());
		
		int resultado = agenteBD.insert(pst);
		return resultado;
	}


}
