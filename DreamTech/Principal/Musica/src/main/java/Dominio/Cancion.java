package Dominio;

	import java.sql.SQLException;
	import java.util.List;

	//import com.mysql.jdbc.util.PropertiesDocGenerator;

	import Persistencia.GestorCanciones;

	public class Cancion {
		protected String Nombre;
		protected String Artista;
		protected double Precio;
		protected GestorCanciones gestorCanciones;

		public Cancion(){
			gestorCanciones = new GestorCanciones();
		}
		
		public Cancion(String Nombre, String Artista, double Precio){
			this.Nombre=Nombre;
			this.Artista=Artista;
			this.Precio=Precio;
			gestorCanciones = new GestorCanciones();
		}
		
		public Cancion (String Nombre){
			this.Nombre=Nombre;
			gestorCanciones = new GestorCanciones();
		}


		
		public String getNombre() {
			return Nombre;
		}

		public void setNombre(String nombre) {
			Nombre = nombre;
		}

		public String getArtista() {
			return Artista;
		}

		public void setArtista(String artista) {
			Artista = artista;
		}

		public double getPrecio() {
			return Precio;
		}

		public void setPrecio(double precio) {
			Precio = precio;
		}

		public GestorCanciones getGestorCanciones() {
			return gestorCanciones;
		}

		public void setGestorCanciones(GestorCanciones gestorCanciones) {
			this.gestorCanciones = gestorCanciones;
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

