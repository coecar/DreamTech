package Dominio;

	import java.sql.SQLException;
	import java.util.List;

	//import com.mysql.jdbc.util.PropertiesDocGenerator;

	import Persistencia.GestorPagos;

	public class PayPal {
		protected int ID;
		protected String Usuario;
		protected double Saldo;
		protected GestorPagos gestorPagos;
		
		public PayPal() throws ClassNotFoundException{
			gestorPagos = new GestorPagos();
		}
		
		public PayPal(int ID, String Usuario, double Saldo){
			this.ID = ID;
			this.Usuario = Usuario;
			this.Saldo= Saldo;
		}
		
		public PayPal (int ID) throws ClassNotFoundException{
			this.ID = ID;
			gestorPagos = new GestorPagos();
		}

		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		public String getUsuario() {
			return Usuario;
		}

		public void setUsuario(String usuario) {
			Usuario = usuario;
		}

		public double getSaldo() {
			return Saldo;
		}

		public void setSaldo(double saldo) {
			Saldo = saldo;
		}

		public GestorPagos getGestorPagos() {
			return gestorPagos;
		}

		public void setGestorPagos(GestorPagos gestorPagos) {
			this.gestorPagos = gestorPagos;
		}
		
		public PayPal leerCancion() throws SQLException {
			return gestorPagos.read(this.ID);
		}
		
		public List<PayPal> leerTodos() throws SQLException {
			return gestorPagos.readAll();
		}
		
		/*public boolean comprobar(String pass){
			return (this.Password.equals(pass));
			
		}*/
		
		public int insertar() throws SQLException{
			return gestorPagos.insert(this);
		}
	}

