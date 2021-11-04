package vista;

import java.awt.Color;
import java.awt.EventQueue;
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

import archivos.LecturaFixture;
import objetos.Campeonato;
import solver.Solver;

public class Main {

	private JTextArea fixtureArea;
	private JScrollPane scrollPane;
	private JFrame frame;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Campeonato c = LecturaFixture.nuevoCampeonato();
		Solver.fixtureEquilibrado(c);

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
		
		fixtureArea = new JTextArea(c.getFixture().toString());
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
				//
			}
		});
		asignarArbitros.setBounds(166, 611, 156, 23);
		frame.getContentPane().add(asignarArbitros);
		
		JButton estadisticasArbitros = new JButton("ESTADISTICAS DE ARBITROS");
		estadisticasArbitros.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		estadisticasArbitros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		estadisticasArbitros.setBounds(150, 658, 184, 23);
		frame.getContentPane().add(estadisticasArbitros);
			
		ImageIcon icon = new ImageIcon("./src/archivos/campoImagen.png");
        JLabel thumb = new JLabel();
        thumb.setVerticalAlignment(SwingConstants.TOP);
        thumb.setBounds(0, 0, 500, 750);
        thumb.setIcon(icon);
        frame.getContentPane().add(thumb);
	}	
}
