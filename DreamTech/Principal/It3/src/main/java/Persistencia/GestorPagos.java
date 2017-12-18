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

	public GestorPagos() throws ClassNotFoundException {
		paypals = new ArrayList<PayPal>();
		agenteBD = Agente.getAgente();
	}

	public PayPal read(int ID) throws SQLException {
		String sql = "SELECT * FROM paypals WHERE ID = '" + ID + "';";
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

		paypal = new PayPal(ID, Usuario, Saldo);
		return paypal;
	}

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

	public int insert(PayPal u) throws SQLException {
		String sql = "INSERT INTO paypals(Id,Usuario,Saldo) VALUES(?,?,?)";
		PreparedStatement pst = agenteBD.getConection().prepareStatement(sql);
		pst.setLong(1, u.getID());
		pst.setString(2, u.getUsuario());
		pst.setDouble(3, u.getSaldo());

		int resultado = agenteBD.insert(pst);
		return resultado;
	}

	public int delete(PayPal u) throws SQLException {
		String sql = "DELETE FROM paypals WHERE Nombre=" + u.getID();
		PreparedStatement pst = agenteBD.getConection().prepareStatement(sql);
		int resultado = agenteBD.delete(sql); // MIRAR A VER SI SE BORRAN ASI DE LA BASE DE DATOS PQ NO ESTOY SEGURO
		return resultado;
	}
}