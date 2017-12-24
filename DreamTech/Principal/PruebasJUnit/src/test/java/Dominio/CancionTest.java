package Dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CancionTest {
	private Cancion c;
	protected String nombre;
	protected boolean comprada;
	protected int precio;

	@Before
	public void setUp() throws Exception {
		c = new Cancion(nombre, comprada, precio);
	}
	
	@Test
	public void testNombreIgual() {
		assertEquals(nombre, c.getNombre());
	}
	
	@Test
	public void testComprada(){
		assertTrue(!c.isComprada());
		assertEquals(c.isComprada(), comprada);
		
	}
	
	@Test
	public void testPrecioIgual(){
		assertEquals(c.getPrecio(), precio);
	}
}
