package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private final JLabel lblUsuario = new JLabel("USUARIO");
	private final JTextField tfUsuario = new JTextField();
	private final JLabel lblPassword = new JLabel("PASSWORD:");
	private final JPasswordField passwordField = new JPasswordField();
	private final JLabel lblSpotifyIngeneria = new JLabel("SPOTIFY - INGENERIA DEL SOFTWARE II");
	private final JButton btnConectar = new JButton("CONECTAR");
	String password = (String.valueOf(passwordField.getPassword()));

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
		tfUsuario.setBounds(193, 97, 165, 20);
		tfUsuario.setColumns(10);
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		{
			lblUsuario.setBounds(90, 100, 46, 14);
			frame.getContentPane().add(lblUsuario);
		}
		{
			frame.getContentPane().add(tfUsuario);
		}
		{
			lblPassword.setBounds(90, 147, 79, 14);
			frame.getContentPane().add(lblPassword);
		}
		{
			passwordField.setBounds(193, 144, 165, 20);
			frame.getContentPane().add(passwordField);
		}
		{
			lblSpotifyIngeneria.setFont(new Font("Rockwell Nova Cond Light", Font.PLAIN, 36));
			lblSpotifyIngeneria.setBounds(22, 26, 412, 57);
			frame.getContentPane().add(lblSpotifyIngeneria);
		}
		{
			btnConectar.addActionListener(new BtnConectarActionListener());
			btnConectar.setBounds(167, 189, 138, 57);
			frame.getContentPane().add(btnConectar);
		}
	}
	private class BtnConectarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(tfUsuario.getText() == "Dreamtech" && password == "B103"){
				VentanaPrincipal v = new VentanaPrincipal();
				v.setVisible(true);
			}
		}
	}
}
