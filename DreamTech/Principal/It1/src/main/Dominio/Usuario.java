package DreamTech.Principal.It1.src.main.Dominio;

	import java.sql.SQLException;
	import java.util.List;

	//import com.mysql.jdbc.util.PropertiesDocGenerator;

	import Persistencia.GestorUsuarios;

	public class Usuario {
		protected String Nick;
		protected String Nombre;
		protected String Email;
		protected String Password;
		protected GestorUsuarios gestorUsuarios;
		
		public Usuario() {
			gestorUsuarios = new GestorUsuarios();
		}
		
		public Usuario(String Nick, String Nombre, String Email, String Password){
			this.Nick=Nick;
			this.Nombre=Nombre;
			this.Email=Email;
			this.Password=Password;
			gestorUsuarios = new GestorUsuarios();
		}
		
		public Usuario(String Nick){
			this.Nick=Nick;
			gestorUsuarios = new GestorUsuarios();
		}

		public String getNick() {
			return Nick;
		}

		public void setNick(String nick) {
			Nick = nick;
		}

		public String getNombre() {
			return Nombre;
		}

		public void setNombre(String nombre) {
			Nombre = nombre;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String password) {
			Password = password;
		}

		public GestorUsuarios getGestorUsuarios() {
			return gestorUsuarios;
		}

		public void setGestorUsuarios(GestorUsuarios gestorUsuarios) {
			this.gestorUsuarios = gestorUsuarios;
		}
		
		public Usuario leerUsuario() throws SQLException {
			return gestorUsuarios.read(this.Nick);
		}
		
		public List<Usuario> leerTodos() throws SQLException {
			return gestorUsuarios.readAll();
		}
		public boolean comprobar(String pass){
			return (this.Password.equals(pass));
			
		}
		
		public int insertar() throws SQLException{
			return gestorUsuarios.insert(this);
		}
	}

