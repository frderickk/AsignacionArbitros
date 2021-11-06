package controlador;

import java.util.ArrayList;

import archivos.LecturaFixture;
import objetos.Arbitro;
import objetos.Campeonato;
import objetos.Fecha;
import objetos.Partido;
import solver.Solver;

public class Controlador {
	
	private Campeonato campeonato;
	
	
	public Controlador() {
		campeonato = LecturaFixture.nuevoCampeonato();
	}
	
	
	public Campeonato getCampeonato() {
		return campeonato;
	}
	
	
	public void resetear() {
		ArrayList<Fecha> fechas = getCampeonato().getFixture().getFechas();
		for (Fecha f : fechas) {
			for (Partido p : f.getPartidos()) {
				if (p.getArbitro() != null) {
					p.setArbitro(null);
				}
			}
		}
	}


	public void fixtureConAsignacionCompleta() {
		Solver.fixtureEquilibrado(campeonato);
	}
	
	
	public String estadistica() {
		return Solver.estadisticasArbitrales(campeonato);
	}

}
