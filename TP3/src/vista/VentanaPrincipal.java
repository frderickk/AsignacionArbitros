package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import controlador.Controlador;
import objetos.Fecha;
import objetos.Partido;

public class VentanaPrincipal {

	private JTextArea fixtureArea;
	private JScrollPane scrollPane;
	private JFrame frame;
	private Controlador controlador;

	
	/**
	 * Constructor de GUI.
	 */
	public VentanaPrincipal() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Inicializa los elementos de la GUI
	 */
	public void inicializar() {
		controlador = new Controlador();

		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setSize(512, 787);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel titulo = new JLabel("LA HORA REFERI !");
		titulo.setBackground(Color.WHITE);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setVerticalAlignment(SwingConstants.BOTTOM);
		titulo.setBounds(107, 59, 284, 52);
		frame.getContentPane().add(titulo);
		
		JLabel sombraTitulo = new JLabel("LA HORA REFERI !");
		sombraTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		sombraTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		sombraTitulo.setForeground(Color.BLACK);
		sombraTitulo.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		sombraTitulo.setBackground(Color.WHITE);
		sombraTitulo.setBounds(108, 59, 290, 52);
		frame.getContentPane().add(sombraTitulo);
		
		fixtureArea = new JTextArea(controlador.getCampeonato().getFixture().toString());
		fixtureArea.setCaretColor(new Color(0, 0, 0));
		fixtureArea.setDisabledTextColor(new Color(128, 128, 128));
		fixtureArea.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		fixtureArea.setBorder(new LineBorder(new Color(255, 255, 255), 5, true));
		fixtureArea.setBackground(new Color(0, 128, 0));
		fixtureArea.setForeground(new Color(255, 255, 255));
		fixtureArea.setLineWrap(true);
		fixtureArea.setEditable(false);
		
		scrollPane = new JScrollPane(fixtureArea);
		scrollPane.setBounds(29, 185, 445, 400);
		frame.getContentPane().add(scrollPane);
		
		JButton asignarArbitros = new JButton("ASIGNAR ARBITROS");
		asignarArbitros.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		asignarArbitros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Fecha f : controlador.getCampeonato().getFixture().getFechas()) {
					for (Partido p : f.getPartidos()) {
						if(p.getArbitro() == null) {
							fixtureArea.setText("");
							controlador.fixtureConAsignacionCompleta();
						}
						else {
							fixtureArea.setText(controlador.getCampeonato().getFixture().toString());
							fixtureArea.setCaretPosition(0);
						}
					}
				}
			}
		});
		asignarArbitros.setBounds(166, 611, 156, 23);
		frame.getContentPane().add(asignarArbitros);
		
		JButton estadisticasArbitros = new JButton("ESTADISTICAS DE ARBITROS");
		estadisticasArbitros.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		estadisticasArbitros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Fecha f : controlador.getCampeonato().getFixture().getFechas()) {
					for (Partido p : f.getPartidos()) {
						if(p.getArbitro() != null) {
							fixtureArea.setText("");
							fixtureArea.setText(controlador.estadistica());
							fixtureArea.setCaretPosition(0);
						}
						else {
							fixtureArea.setText(controlador.getCampeonato().getFixture().toString());
							fixtureArea.setCaretPosition(0);
						}
					}
				}
			}
		});
		estadisticasArbitros.setBounds(150, 658, 184, 23);
		frame.getContentPane().add(estadisticasArbitros);
			
		ImageIcon imagen = new ImageIcon("./src/archivos/campoImagen.png");
        JLabel labelImagen = new JLabel();
        labelImagen.setVerticalAlignment(SwingConstants.TOP);
        labelImagen.setBounds(0, 0, 500, 750);
        labelImagen.setIcon(imagen);
        frame.getContentPane().add(labelImagen);
        
        frame.setVisible(true);
	}	
}
