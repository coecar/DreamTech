package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel label;

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
			textField = new JTextField();
			textField.setBounds(179, 46, 86, 20);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
		}
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setBounds(89, 49, 46, 14);
			frame.getContentPane().add(lblUsuario);
		}
		{
			lblContrasea = new JLabel("Contraseña");
			lblContrasea.setBounds(89, 93, 86, 14);
			frame.getContentPane().add(lblContrasea);
		}
		{
			label = new JLabel("");
			label.setBounds(203, 77, 46, 14);
			frame.getContentPane().add(label);
		}
	}
}
