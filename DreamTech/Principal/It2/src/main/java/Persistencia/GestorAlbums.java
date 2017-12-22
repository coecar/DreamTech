package Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dominio.Album;
/**
 * 
 * @author Miguel de la cal, Carlos Coello, Miguel Ángel García,
 * Werselio Escribano.
 */
public class GestorAlbums {
	/**
	 * Variable que hace referencia al agente de la base de datos.
	 */
	private Agente agenteBD;
	/**
	 * Variable donde se almacenan los albunes.
	 */
	private List<Album> albums;
	/**
	 * Constructor de la clase.
	 * @throws ClassNotFoundException Excepción de clase.
	 */
	public GestorAlbums() throws ClassNotFoundException {
		albums = new ArrayList<Album>();
		agenteBD = Agente.getAgente();
	}
	/**
	 * Metodo para leer un album de la base de datos.
	 * @param Nombre del album a leer..
	 * @return album leido de la base de datos.
	 * @throws SQLException Excepción de base de datos.
	 * @throws ClassNotFoundException Excepción de clase.
	 */
	public Album read(String Nombre) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM usuarios WHERE Nick = '"+Nombre+"';";
		String Artista = null;
		double Precio = 0;
		ResultSet rs;
		rs = agenteBD.read(sql);
		if (rs.next()) {
			Nombre = rs.getString("Nombre");
			Artista = rs.getString("Artista");
			Precio = rs.getDouble("Precio");
		}
		return  new Album(Nombre,Artista,Precio);
	}
	/**
	 * Metodo para leer todos los albunes de la base de datos.
	 * @return lista de albums leidos de la base de datos.
	 * @throws SQLException Excepción de base de datos.
	 * @throws ClassNotFoundException Excepción de clase.
	 */
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
	/**
	 * Metodo que se usa para insertar un album en la base de datos.
	 * @param album que se quiere insertar en la base de datos.
	 * @return resultado Entero que dice si se ha insertado correctamente.
	 * @throws SQLException Excepción de base de datos.
	 */
	public int insert(Album album) throws SQLException{
		String sql = "INSERT INTO usuarios(Nick,Nombre,Apellido,Password) VALUES(?,?,?,?)";
		PreparedStatement pst = agenteBD.getConection().prepareStatement(sql);
		pst.setString(1, album.getNombre());
		pst.setString(2, album.getArtista());
		pst.setDouble(3, album.getPrecio());	
		int resultado = agenteBD.insert(pst);
		return resultado;
	}
	/**
	 * Metodo para eliminar un album de la base de datos.
	 * @param album para eliminar de la base de datos.
	 * @return resultado Entero que dice si se ha eliminado correctamente.
	 * @throws SQLException Excepción de base de datos.
	 */
	public int delete(Album album) throws SQLException{
		String sql = "DELETE FROM albums WHERE Nombre="+album.getNombre();
		agenteBD.getConection().prepareStatement(sql);
		int resultado = agenteBD.delete(sql); //MIRAR A VER SI SE BORRAN ASI DE LA BASE DE DATOS PQ NO ESTOY SEGURO
		return resultado;
	}
}
