package Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Agente {
	private static Agente yo;
	private Connection connection;
	private String nombreBD = "sis_usuarios";
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/"+nombreBD;
	
	private Agente() throws ClassNotFoundException {
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
		if (yo==null)
			yo=new Agente();
		return yo;
	}
	
	public Connection getConection() {
		return connection;
	}
	
	public int insert(String sql) throws SQLException {
		Statement statement;
		int rs;
		
		statement = connection.createStatement();
		rs = statement.executeUpdate(sql);
		
		return rs;
	}
	
	public ResultSet read(String sql) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		return rs;
	}
	
	public int insert(PreparedStatement ps) throws SQLException {
		int rs;
		rs = ps.executeUpdate();
		
		return rs;
	}
	
	public int update(PreparedStatement ps) throws SQLException {
		int rs = ps.executeUpdate();
		
		return rs;
	}
	
	public int update(String sql) throws SQLException {
		Statement statement = connection.createStatement();
		int rs = statement.executeUpdate(sql);
		
		return rs;
	}
	
	public int delete(String sql) throws SQLException {
		Statement statement = connection.createStatement();
		int rs = statement.executeUpdate(sql);
		
		return rs;
	}

	
}
