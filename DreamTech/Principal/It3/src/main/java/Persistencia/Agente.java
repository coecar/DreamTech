package Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos Coello, Miguel Angel Garcia, Werselio Escribano, Miguel de
 *         laCal.
 */
class Agente {
	/**
	 * Agente para gestionar la base de datos.
	 */
	private static Agente miInstancia;
	/**
	 * Objeto que instancia la conexión de la base de datos.
	 */
	private Connection connection;
	/**
	 * String que almacena el nombre de la base de datos.
	 */
	private String nombreBD = "sis_usuarios";
	/**
	 * String que almacena el driver que es encargado de conectar la base de
	 * datos.
	 */
	private String driver = "com.mysql.jdbc.Driver";
	/**
	 * String utilizado para la conexión de la base de datos.
	 */
	private String url = "jdbc:mysql://localhost:3306/" + nombreBD;
	private Agente() throws ClassNotFoundException {
		/**
		 * Este metodo se utiliza para realizar la conexión con la base de
		 * datos del sistema.
		 */
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, "root", "");
			System.out.println("Hola");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fallo al conectar con BD");
			e.printStackTrace();
		}
	}
	public static Agente getAgente() throws ClassNotFoundException {
		/**
		 * Este método es usado para conectar la base de datos desde
		 * fuera de esta clase debido a que el método anterior esta
		 * declarado private.
		 * @return yo se devuelve el objeto agente.
		 */
		if (miInstancia == null) {
			miInstancia = new Agente();
		}
		return miInstancia;
	}
	public Connection getConection() {
		/**
		 * Este método devuelve el objeto Conection.
		 * 
		 * @return connection
		 */
		return connection;
	}
	public int insert(String sql) throws SQLException {
		/**
		 * Este metodo se utiliza para introducir datos a la base de datos.
		 * @param sql
		 * @return rs
		 * @throws SQLException
		 */
		Statement statement;
		int rs;
		statement = connection.createStatement();
		rs = statement.executeUpdate(sql);
		statement.close();
		return rs;
	}
	public ResultSet read(String sql) throws SQLException {
		/**
		 * Este método se utiliza para leer los diferentes cambios de la
		 * base de datos.
		 * @param sql
		 * @return rs
		 * @throws SQLException
		 */
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		statement.close();
		return rs;
	}
	public int insert(PreparedStatement ps) throws SQLException {
		/**
		 * Este método se utiliza para introducir nuevos registros a la
		 * base de datos.
		 * @param ps
		 * @return rs
		 * @throws SQLException
		 */
		int rs;
		rs = ps.executeUpdate();
		return rs;
	}
	public int update(PreparedStatement ps) throws SQLException {
		/**
		 * Este método se utiliza para actualizar los campos de la base de
		 * datos.
		 * @param ps
		 * @return rs
		 * @throws SQLException
		 */
		int rs = ps.executeUpdate();
		return rs;
	}
	public int update(String sql) throws SQLException {
		/**
		 * Este método se utiliza para actualizar los campos de la base de
		 * datos.
		 * @param sql
		 * @return rs
		 * @throws SQLException
		 */
		Statement statement = connection.createStatement();
		int rs = statement.executeUpdate(sql);
		statement.close();
		return rs;
	}
	public int delete(String sql) throws SQLException {
		/**
		 * Este método se utiliza para borrar cualquier dato de la base
		 * de datos.
		 * @param sql
		 * @return rs
		 * @throws SQLException
		 */
		Statement statement = connection.createStatement();
		int rs = statement.executeUpdate(sql);
		statement.close();
		return rs;
	}
}
