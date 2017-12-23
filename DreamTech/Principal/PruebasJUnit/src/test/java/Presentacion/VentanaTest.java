package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dominio.Cancion;
import Dominio.Usuario;
import Persistencia.GestorCanciones;
import Persistencia.GestorUsuarios;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaTest extends JFrame {

	private JPanel contentPane;
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
	
	boolean rep=false;
	private JButton btnNewButton;
	private JLabel labelNickUser;
	private JList list;
	private JLabel lblTitulo1;
	private JLabel lblPrecio;
	private JButton buttonPlay;
	private JButton buttonPause;
	private JButton buttonRewind;
	private JButton buttonFF;
	private JLabel lblTituloPers;
	private JLabel lblPrecioPers;
	private JLabel labelTiempoTrans;
	private JLabel labelDuracion;
	private JButton btnComprarCancion;
	private JLabel labelUser;
	private JLabel lblSaldo;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public VentanaTest(Usuario u) throws IOException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			list = new JList();
			list.addMouseListener(new ListMouseListener());
			list.setBounds(10, 11, 161, 322);
			contentPane.add(list);
		}
		{
			lblTitulo1 = new JLabel("Titulo: ");
			lblTitulo1.setBounds(223, 75, 46, 14);
			contentPane.add(lblTitulo1);
		}
		{
			lblPrecio = new JLabel("Precio");
			lblPrecio.setBounds(223, 100, 46, 14);
			contentPane.add(lblPrecio);
		}
		{
			buttonPlay = new JButton("");
			buttonPlay.addActionListener(new ButtonPlayActionListener());
			buttonPlay.setIcon(new ImageIcon(Ventana.class.getResource("/Presentacion/play-button.png")));
			buttonPlay.setBounds(322, 171, 49, 25);
			contentPane.add(buttonPlay);
		}
		{
			buttonPause = new JButton("");
			buttonPause.addActionListener(new ButtonPauseActionListener());
			buttonPause.setIcon(new ImageIcon(Ventana.class.getResource("/Presentacion/pause-multimedia-big-gross-symbol-lines.png")));
			buttonPause.setBounds(260, 171, 49, 25);
			contentPane.add(buttonPause);
		}
		{
			buttonRewind = new JButton("");
			buttonRewind.setIcon(new ImageIcon(Ventana.class.getResource("/Presentacion/rewind.png")));
			buttonRewind.setBounds(203, 171, 49, 25);
			contentPane.add(buttonRewind);
		}
		{
			buttonFF = new JButton("");
			buttonFF.setIcon(new ImageIcon(Ventana.class.getResource("/Presentacion/fast-forward-media-control-button (1).png")));
			buttonFF.setBounds(381, 171, 49, 25);
			contentPane.add(buttonFF);
		}
		{
			lblTituloPers = new JLabel("");
			lblTituloPers.setBounds(279, 75, 46, 14);
			contentPane.add(lblTituloPers);
		}
		{
			lblPrecioPers = new JLabel("");
			lblPrecioPers.setBounds(279, 100, 46, 14);
			contentPane.add(lblPrecioPers);
		}
		{
			labelTiempoTrans = new JLabel("(TIEMPO TRANSCURRIDO)");
			labelTiempoTrans.setBounds(215, 143, 129, 14);
			contentPane.add(labelTiempoTrans);
		}
		{
			labelDuracion = new JLabel("/(DURACION)");
			labelDuracion.setBounds(348, 143, 129, 14);
			contentPane.add(labelDuracion);
		}
		{
			btnComprarCancion = new JButton("COMPRAR CANCION");
			btnComprarCancion.addActionListener(new BtnComprarCancionActionListener());
			btnComprarCancion.setBounds(231, 229, 182, 78);
			contentPane.add(btnComprarCancion);
		}
		{
			labelUser = new JLabel("");
			labelUser.setBounds(348, 32, 74, 14);
			contentPane.add(labelUser);
		}
		
		GestorCanciones gc = new GestorCanciones();
		Cancion[] arrayCanciones = gc.leerCanciones();
		DefaultListModel modeloCanciones = new DefaultListModel();
		
		for(int i=0; i<arrayCanciones.length;i++){
			modeloCanciones.addElement(arrayCanciones[i].getNombre());
			list.setModel(modeloCanciones);
		}
		
		labelUser.setText(u.getNick());
		{
			lblSaldo = new JLabel("");
			lblSaldo.setBounds(431, 32, 46, 14);
			contentPane.add(lblSaldo);
		}
		lblSaldo.setText(": "+u.getSaldo()+"€");
	}
	private class ButtonPlayActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			GestorCanciones gc = new GestorCanciones();
			rep=gc.reproducir();
		}
	}
	private class ButtonPauseActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GestorCanciones gc = new GestorCanciones();
			rep=gc.pausar();
		}
	}
	private class BtnComprarCancionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try {
				int index = list.getSelectedIndex();
				GestorCanciones gc = new GestorCanciones();
				Cancion[] canciones = gc.leerCanciones();
				String Nick = labelUser.getText();
				GestorUsuarios gu = new GestorUsuarios();
				Usuario u = gu.devolverUsuario(Nick);
				
				if(canciones[index].isComprada()){
					System.out.println("Ya está comprada");
					
				}else{
					if(gc.comprarCancion(u, canciones[index])==false){
						int NuevoSaldo = gu.comprarCanciones(canciones[index], u);
						Usuario[] usuarios=gu.cambiarSaldo(u, NuevoSaldo);
						lblSaldo.setText(": "+NuevoSaldo+"€");
					}
				}
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class ListMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			int index = list.getSelectedIndex();
			GestorCanciones gc = new GestorCanciones();
			Cancion[] canciones;
			try {
				canciones = gc.leerCanciones();
				lblTituloPers.setText(canciones[index].getNombre());
				lblPrecioPers.setText(""+canciones[index].getPrecio());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
