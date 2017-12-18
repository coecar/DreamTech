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
	
	public GestorCanciones() throws ClassNotFoundException {
		canciones = new ArrayList<Cancion>();
		agenteBD = Agente.getAgente();
	}
	
	public Cancion read(String Nombre) throws SQLException, ClassNotFoundException {
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
	
	public List<Cancion> readAll() throws SQLException, ClassNotFoundException {
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
		pst.setString(1, c.getNombre());
		pst.setString(2, c.getArtista());
		pst.setDouble(3, c.getPrecio());
		
		int resultado = agenteBD.insert(pst);
		return resultado;
	}
	
	public int delete(Cancion c) throws SQLException{
		String sql = "DELETE FROM canciones WHERE Nombre="+c.getNombre();
		PreparedStatement pst = agenteBD.getConection().prepareStatement(sql);
		int resultado = agenteBD.delete(sql); //MIRAR A VER SI SE BORRAN ASI DE LA BASE DE DATOS PQ NO ESTOY SEGURO
		return resultado;
	}


}
