package Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dominio.Album;

public class GestorAlbums {
	private Agente agenteBD;
	private List<Album> albums;
	
	public GestorAlbums() throws ClassNotFoundException {
		albums = new ArrayList<Album>();
		agenteBD = Agente.getAgente();
	}
	
	public Album read(String Nombre) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM usuarios WHERE Nick = '"+Nombre+"';";
		String Artista = null;
		double Precio = 0;
		int id=0;
		Album album;
		ResultSet rs;
		
		rs = agenteBD.read(sql);
		
		if (rs.next()) {
			Nombre = rs.getString("Nombre");
			Artista = rs.getString("Artista");
			Precio = rs.getDouble("Precio");
		}
		
		return album = new Album(Nombre,Artista,Precio);
	}
	
	public List<Album> readAll() throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM usuarios";
		String Nombre = null, Artista = null;
		Double Precio;
		ResultSet rs;
		
		rs = agenteBD.read(sql);
		
		while(rs.next()) {
			Nombre = rs.getString("Nombre");
			Artista = rs.getString("Artista");
			Precio = rs.getDouble("Precio");
			albums.add(new Album(Nombre,Artista,Precio));
		}
		
		return albums;
	}
	
	public int insert(Album a) throws SQLException{
		String sql = "INSERT INTO usuarios(Nick,Nombre,Apellido,Password) VALUES(?,?,?,?)";
		PreparedStatement pst = agenteBD.getConection().prepareStatement(sql);
		pst.setString(1, a.getNombre());
		pst.setString(2, a.getArtista());
		pst.setDouble(3, a.getPrecio());
		
		int resultado = agenteBD.insert(pst);
		return resultado;
	}
	
	public int delete(Album a) throws SQLException{
		String sql = "DELETE FROM albums WHERE Nombre="+a.getNombre();
		PreparedStatement pst = agenteBD.getConection().prepareStatement(sql);
		int resultado = agenteBD.delete(sql); //MIRAR A VER SI SE BORRAN ASI DE LA BASE DE DATOS PQ NO ESTOY SEGURO
		return resultado;
	}


}
