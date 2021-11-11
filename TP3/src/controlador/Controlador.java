package controlador;

import archivos.LecturaJson;
import objetos.Campeonato;
import objetos.Fecha;
import objetos.Partido;
import solver.Solver;


public class Controlador {
	
	private Campeonato campeonato;
	private String[] posibilidades;
	
	
	/**
	 * Constructor de controlador
	 */
	public Controlador() {
		campeonato = LecturaJson.nuevoCampeonato();
		posibilidades = new String[] {"Alvarez", "Bagnes", "Espinillo", "Farias", "Irigoyen", "Juarez", "Marenco", "Nandez", "Quillez", "Ramirez"};
	}
	
	
	//Getters
	public Campeonato getCampeonato() {
		return campeonato;
	}
	
	
	
	public String[] getPosibilidades() {
		return posibilidades;
	}


	/**
	 * Metodo para utilizar en el reinicio de los arbitros en la app
	 */
	public void resetearNombre() {
		for (Fecha f : getCampeonato().getFixture().getFechas()) {
			for (Partido p : f.getPartidos()) {
				if (p.getArbitro() != null) {
					p.getArbitro().setNombre(null);
					p.setArbitro(null);
				}
			}
		}
	}


	/**
	 * Inicia el metodo del solver que equilibra y asigna arbitros
	 */
	public void fixtureConAsignacionCompleta() {
		Solver.fixtureEquilibrado(campeonato);
	}

}
