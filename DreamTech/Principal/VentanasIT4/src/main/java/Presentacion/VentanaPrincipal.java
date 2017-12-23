package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaPrincipal {

	private JFrame frame;
	private final JList lstCanciones = new JList();
	private final JButton btnPlay = new JButton("");
	private final JButton btnPause = new JButton("");
	private final JButton btnRewind = new JButton("");
	private final JButton btnFastForward = new JButton("");
	private final JLabel lblTitulo = new JLabel("Titulo:");
	private final JLabel lblAutor = new JLabel("Autor: ");
	private final JLabel lblRellenaTitulo = new JLabel("(Titulo de la cancion)");
	private final JLabel lblRellenaAutor = new JLabel("(Autor de la cancin)");
	private final JLabel lblTiempoTranscurrido = new JLabel("(Tiempo transcurrido)");
	private final JLabel lblduracion = new JLabel("/(Duracion)");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 597, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		{
			lstCanciones.setModel(new AbstractListModel() {
				String[] values = new String[] {"A Belen Pastores", "Campana Sobre Campana", "Hacia Belen Va Una Burra"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			lstCanciones.setBounds(10, 11, 187, 408);
			frame.getContentPane().add(lstCanciones);
		}
		{
			btnPlay.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Presentacion/play-button.png")));
			btnPlay.setBounds(343, 236, 49, 25);
			frame.getContentPane().add(btnPlay);
		}
		{
			btnPause.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Presentacion/pause-multimedia-big-gross-symbol-lines.png")));
			btnPause.setBounds(402, 236, 49, 25);
			frame.getContentPane().add(btnPause);
		}
		{
			btnRewind.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Presentacion/rewind.png")));
			btnRewind.setBounds(284, 236, 49, 25);
			frame.getContentPane().add(btnRewind);
		}
		{
			btnFastForward.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Presentacion/fast-forward-media-control-button (1).png")));
			btnFastForward.setBounds(461, 236, 49, 25);
			frame.getContentPane().add(btnFastForward);
		}
		{
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblTitulo.setBounds(242, 92, 48, 21);
			frame.getContentPane().add(lblTitulo);
		}
		{
			lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblAutor.setBounds(242, 124, 52, 21);
			frame.getContentPane().add(lblAutor);
		}
		{
			lblRellenaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblRellenaTitulo.setBounds(324, 92, 158, 21);
			frame.getContentPane().add(lblRellenaTitulo);
		}
		{
			lblRellenaAutor.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblRellenaAutor.setBounds(324, 124, 157, 21);
			frame.getContentPane().add(lblRellenaAutor);
		}
		{
			lblTiempoTranscurrido.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTiempoTranscurrido.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblTiempoTranscurrido.setBounds(233, 187, 198, 21);
			frame.getContentPane().add(lblTiempoTranscurrido);
		}
		{
			lblduracion.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblduracion.setBounds(430, 187, 87, 21);
			frame.getContentPane().add(lblduracion);
		}
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
