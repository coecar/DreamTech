package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Dominio.Usuario;
import Persistencia.GestorUsuarios;

import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField tfNick;
	private JPasswordField passwordField;
	private JButton btnEntrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		{
			tfNick = new JTextField();
			tfNick.setBounds(115, 63, 200, 20);
			frame.getContentPane().add(tfNick);
			tfNick.setColumns(10);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(158, 116, 101, 20);
			frame.getContentPane().add(passwordField);
		}
		{
			btnEntrar = new JButton("ENTRAR");
			btnEntrar.addActionListener(new BtnEntrarActionListener());
			btnEntrar.setBounds(170, 178, 89, 23);
			frame.getContentPane().add(btnEntrar);
		}
	}
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try {
				String Nick = tfNick.getText();
				String Pass = String.valueOf(passwordField.getPassword());
				GestorUsuarios gu = new GestorUsuarios();
				Usuario[] usuarios = gu.leerUsuarios();
				Usuario u = new Usuario(Nick, Pass);
				
				boolean logueado = gu.logIn(Nick, Pass, usuarios);
				if(logueado==true){
					VentanaPrincipal vp = new VentanaPrincipal();
					System.out.println("Logueado");
					vp.main(null);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}
}
