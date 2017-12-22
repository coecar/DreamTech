package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dominio.Cancion;
/**
 * 
 * @author Miguel de la cal, Carlos Coello, Miguel Ángel García,
 * Werselio Escribano.
 */
public class GestorCanciones {
	/**
	 * Variable que almacena el agente de la base de datos.
	 */
	private Agente agenteBD;
	/**
	 * Variable que almacena todas las canciones.
	 */
	private List<Cancion> canciones;
	/**
	 * Metodo constructor de la clase.
	 * @throws ClassNotFoundException Excepción de clase.
	 */
	public GestorCanciones() throws ClassNotFoundException {
		canciones = new ArrayList<Cancion>();
		agenteBD = Agente.getAgente();
	}
	/**
	 * Metodo usado para leer una canción de la base de datos.
	 * @param Nombre de la canción a leer.
	 * @return cancion leida.
	 * @throws SQLException Excepción de base de datos.
	 * @throws ClassNotFoundException Excepción de clase.
	 */
	public Cancion read(String Nombre) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM usuarios WHERE Nick = '" + Nombre + "';";
		String Artista = null;
		double Precio = 0;
		ResultSet rs;
		rs = agenteBD.read(sql);
		if (rs.next()) {
			Nombre = rs.getString("Nombre");
			Artista = rs.getString("Artista");
			Precio = rs.getDouble("Precio");
		}
		return new Cancion(Nombre, Artista, Precio);
	}
	/**
	 * Metodo para leer todas las canciones de la base de datos.
	 * @return la lista de canciones de la base de datos.
	 * @throws SQLException Excepción de base de datos.
	 * @throws ClassNotFoundException Excepción de clase.
	 */
	public List<Cancion> readAll() throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM usuarios";
		String Nombre = null, Artista = null;
		Double Precio;
		ResultSet rs;
		rs = agenteBD.read(sql);
		while (rs.next()) {
			Nombre = rs.getString("Nombre");
			Artista = rs.getString("Artista");
			Precio = rs.getDouble("Precio");
			canciones.add(new Cancion(Nombre, Artista, Precio));
		}
		return canciones;
	}
	/**
	 * Metodo para insertar una cancion en la base de datos.
	 * @param cancion que se quiere insertar en la base de datos.
	 * @return resultado un entero que dice si se ha insertado correctamente.
	 * @throws SQLException Excepción de base de datos.
	 */
	public int insert(Cancion cancion) throws SQLException {
		String sql = "INSERT INTO usuarios(Nick,Nombre,Apellido,Password) VALUES(?,?,?,?)";
		PreparedStatement pst = agenteBD.getConection().prepareStatement(sql);
		pst.setString(1, cancion.getNombre());
		pst.setString(2, cancion.getArtista());
		pst.setDouble(3, cancion.getPrecio());

		int resultado = agenteBD.insert(pst);
		return resultado;
	}
	/**
	 * Metodo para eliminar una cancion de la base de datos.
	 * @param cancion que se quiere eliminar de la base de datos.
	 * @return resultado Entero que dice si se ha eliminado correctamente.
	 * @throws SQLException Excepción de base de datos.
	 */
	public int delete(Cancion cancion) throws SQLException {
		String sql = "DELETE FROM canciones WHERE Nombre=" + cancion.getNombre();
		agenteBD.getConection().prepareStatement(sql);
		int resultado = agenteBD.delete(sql); 
		return resultado;
	}

}
