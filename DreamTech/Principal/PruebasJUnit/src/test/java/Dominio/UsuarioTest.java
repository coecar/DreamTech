package Dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import Persistencia.GestorUsuarios;

public class UsuarioTest {
	
	private Usuario u;
	private GestorUsuarios gu = new GestorUsuarios();
	protected String Nick;
	protected String Password;
	protected int saldo;
	
	@Before
	public void setUp() throws Exception {
		u = new Usuario(Nick, Password, saldo);
	}
	
	@Test
	public void testNickIgual(){
		assertEquals(Nick, u.getNick());
		
	}
	
	@Test
	public void testSaldo() throws IOException{
		assertTrue(saldo==0);
		/*Usuario [] usuarios = gu.leerUsuarios();
		for(int i = 0; i<= usuarios.length; i++){
			assertTrue(usuarios[i].getSaldo()>0);
		}*/
		
		
	}
	@Test
	public void testPasswordIgual(){
		assertEquals(u.getPassword(), Password);
	}


}
