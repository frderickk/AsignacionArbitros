package main;

import java.awt.EventQueue;
import vista.VentanaPrincipal;

public class LaHoraReferiApp {
	
	public static VentanaPrincipal app;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app = new VentanaPrincipal();
					app.inicializar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
