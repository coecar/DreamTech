package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dominio.PayPal;
/**
 * 
 * @author Werselio Escribano, Miguel de la Cal, Carlos Coello,
 * Miguel Angel García.
 *
 */
public class GestorPagos {
	/**
	 * Variable que hace referencia al agente de la base de datos.
	 */
	private Agente agenteBD;
	/**
	 * Lista donde se almacenan y gestionan los paypals.
	 */
	private List<PayPal> paypals;
	/**
	 * Metodo constructor de la clase.
	 * @throws ClassNotFoundException Excepcion de clase.
	 */
	public GestorPagos() throws ClassNotFoundException {
		paypals = new ArrayList<PayPal>();
		agenteBD = Agente.getAgente();
	}
	/**
	 * Metodo usado para leer una cuenta paypal
	 * @param id_cuenta.
	 * @return la cuenta paypal leida de la base de datos.
	 * @throws SQLException Excepción de base de datos.
	 */
	public PayPal read(int id_cuenta) throws SQLException {
		String sql = "SELECT * FROM paypals WHERE ID = '" + id_cuenta + "';";
		String Usuario = null;
		double Saldo = 0;
		ResultSet rs;
		rs = agenteBD.read(sql);
		if (rs.next()) {
			id_cuenta = rs.getInt("ID");
			Usuario = rs.getString("Usuario");
			Saldo = rs.getDouble("Saldo");
		}
		return new PayPal(id_cuenta, Usuario, Saldo);
	}
	/**
	 * Metodo usado para leer todos los registros.
	 * @return lista de cuentas de la base de datos.
	 * @throws SQLException Excepción de base de datos.
	 */
	public List<PayPal> readAll() throws SQLException {
		String sql = "SELECT * FROM paypals";
		int Id = 0;
		String Usuario = null;
		double Saldo = 0.0;
		ResultSet rs;
		rs = agenteBD.read(sql);
		while (rs.next()) {
			Id = rs.getInt("Id");
			Usuario = rs.getString("Usuario");
			Saldo = rs.getDouble("Saldo");
			paypals.add(new PayPal(Id, Usuario, Saldo));
		}
		return paypals;
	}
	/**
	 * Metodo usado para insertar un elemento en la base de datos.
	 * @param paypal a insertar en la base de datos.
	 * @return entero que dice si se ha insertado correctamente.
	 * @throws SQLException Excepción de base de datos.
	 */
	public int insert(PayPal paypal) throws SQLException {
		String sql = "INSERT INTO paypals(Id,Usuario,Saldo) VALUES(?,?,?)";
		PreparedStatement pst = agenteBD.getConection().prepareStatement(sql);
		pst.setLong(1, paypal.getID());
		pst.setString(2, paypal.getUsuario());
		pst.setDouble(3, paypal.getSaldo());
		int resultado = agenteBD.insert(pst);
		return resultado;
	}
	/**
	 * Metodo usado para eliminar una cuenta paypal de la base de datos.
	 * @param paypal a borrar de la base de datos.
	 * @return entero que dice si se ha eliminado correctamente.
	 * @throws SQLException Excepción de base de datos.
	 */
	public int delete(PayPal paypal) throws SQLException {
		String sql = "DELETE FROM paypals WHERE Nombre=" + paypal.getID();
		agenteBD.getConection().prepareStatement(sql);
		int resultado = agenteBD.delete(sql); // MIRAR A VER SI SE BORRAN ASI DE LA BASE DE DATOS PQ NO ESTOY SEGURO
		return resultado;
	}
}