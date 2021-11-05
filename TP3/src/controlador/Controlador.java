package controlador;

import archivos.LecturaFixture;
import objetos.Campeonato;
import solver.Solver;

public class Controlador {
	
	private Campeonato campeonato;
	
	
	public Controlador() {
		campeonato = LecturaFixture.nuevoCampeonato();
	}
	
	
	public Campeonato getCampeonato() {
		return campeonato;
	}


	public void fixtureConAsignacionCompleta() {
		Solver.fixtureEquilibrado(campeonato);
	}
	
	
	public String estadistica() {
		return Solver.estadisticasArbitrales(campeonato);
	}

}
