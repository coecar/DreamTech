package Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dominio.Cancion;

public class GestorCanciones {
	private Agente agenteBD;
	private List<Cancion> canciones;
	
	public GestorCanciones() {
		canciones = new ArrayList<>();
		agenteBD = Agente.getAgente();
	}
	
	public Cancion read(String Nombre) throws SQLException {
		String sql = "SELECT * FROM usuarios WHERE Nick = '"+Nombre+"';";
		String Artista = null;
		double Precio = 0;
		int id=0;
		Cancion cancion;
		ResultSet rs;
		
		rs = agenteBD.read(sql);
		
		if (rs.next()) {
			Nombre = rs.getString("Nombre");
			Artista = rs.getString("Artista");
			Precio = rs.getDouble("Precio");
		}
		
		return cancion=new Cancion(Nombre,Artista,Precio);
	}
	
	public List<Cancion> readAll() throws SQLException {
		String sql = "SELECT * FROM usuarios";
		String Nombre = null, Artista = null;
		Double Precio;
		ResultSet rs;
		
		rs = agenteBD.read(sql);
		
		while(rs.next()) {
			Nombre = rs.getString("Nombre");
			Artista = rs.getString("Artista");
			Precio = rs.getDouble("Precio");
			canciones.add(new Cancion(Nombre,Artista,Precio));
		}
		
		return canciones;
	}
	
	public int insert(Cancion c) throws SQLException{
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
