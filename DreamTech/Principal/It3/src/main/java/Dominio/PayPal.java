package Dominio;

import java.sql.SQLException;
import java.util.List;
import Persistencia.GestorPagos;
/**
 * 
 * @author Werselio Escribano, Miguel de la Cal, Carlos Coello,
 * Miguel Angel García.
 *
 */
public class PayPal {
	/**
	 * Variable entera que representa el id de cuenta.
	 */
	protected int id_cuenta;
	/**
	 * String que almacena el usuario.
	 */
	protected String usuario;
	/**
	 * Double que almacena el saldo de la cuenta.
	 */
	protected double saldo;
	/**
	 * Gestor usado para la persistencia.
	 */
	protected GestorPagos gestorPagos;
	/**
	 * Metodo constructor de la clase.
	 * @throws ClassNotFoundException Excepcion de clase.
	 */
	public PayPal() throws ClassNotFoundException {
		gestorPagos = new GestorPagos();
	}
	/**
	 * Metodo constructor de la clase.
	 * @param ID de la cuenta.
	 * @param Usuario de la cuenta.
	 * @param Saldo inicial de la cuenta.
	 */
	public PayPal(int ID, String Usuario, double Saldo) {
		this.id_cuenta = ID;
		this.usuario = Usuario;
		this.saldo = Saldo;
	}
	/**
	 * Metodo constructor de la clase.
	 * @param ID de la cuenta a crear.
	 * @throws ClassNotFoundException Excepcion de clase.
	 */
	public PayPal(int ID) throws ClassNotFoundException {
		this.id_cuenta = ID;
		gestorPagos = new GestorPagos();
	}
	/**
	 * Metodo para devolver el id de la cuenta.
	 * @return id_cuenta a devolver.
	 */
	public int getID() {
		return id_cuenta;
	}
	/**
	 * Metodo para cambiar el id de la cuenta.
	 * @param iD de la cuenta a cambiar.
	 */
	public void setID(int iD) {
		id_cuenta = iD;
	}
	/**
	 * Metodo que devueve el usuario.
	 * @return usuario, de la cuenta.
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * Metodo para cambiar el nombre de Usuario.
	 * @param usuario a cambiar.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * Metodo para devolver el saldo de la cuenta.
	 * @return saldo de la cuenta.
	 */
	public double getSaldo() {
		return saldo;
	}
	/**
	 * Metodo para cambiar el saldo de la cuenta.
	 * @param saldo saldo a cambiar.
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	/**
	 * Metodo para obtener el gestor.
	 * @return devuelve el gestorPagos.
	 */
	public GestorPagos getGestorPagos() {
		return gestorPagos;
	}
	/**
	 * Metodo para asignar un nuevo gestor.
	 * @param gestorPagos de a asignar.
	 */
	public void setGestorPagos(GestorPagos gestorPagos) {
		this.gestorPagos = gestorPagos;
	}
	/**
	 * Metodo para leer un paypal.
	 * @return resultado del metodo leer del gestor.
	 * @throws SQLException
	 */
	public PayPal leerpaypal() throws SQLException {
		return gestorPagos.read(this.id_cuenta);
	}
	/**
	 * Metodo para leer todos los paypal.
	 * @return resultado del metodo leertodos del gestor.
	 * @throws SQLException Excepción de base de datos.
	 */
	public List<PayPal> leerTodos() throws SQLException {
		return gestorPagos.readAll();
	}
	/**
	 * Metodo para insertar registros en la base de datos.
	 * @return resultado del metodo insert del gestor.
	 * @throws SQLException Excepción de base de datos.
	 */
	public int insertar() throws SQLException {
		return gestorPagos.insert(this);
	}
}
