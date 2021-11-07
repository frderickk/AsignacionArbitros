package controlador;

import java.util.ArrayList;
import archivos.LecturaFixture;
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
					p.getArbitro().setNombre(null);
					p.setArbitro(null);
				}
			}
		}
	}


	public void fixtureConAsignacionCompleta() {
		Solver.fixtureEquilibrado(campeonato);
	}
	
	
//	public String estadistica() {
//		StringBuilder sb = new StringBuilder();
//		ArrayList<Fecha> fechas = campeonato.getFixture().getFechas();
//		HashSet<Partido> cantidad = new HashSet<Partido>();
//		for (Fecha f : fechas) {
//			for (Partido p : f.getPartidos()) {
//				if(cantidad.add(p)) {
//					sb.append("Equipo: " + p.getLocal().getArbitroPorFechas() + "\n");
//					sb.append("Cantidad de partidos: " + p.getVisitante().getArbitroPorFechas() + "\n");
//					sb.append("-----------------------------------\n");
//				}
//			}
//		}
//		return sb.toString().replace(",", "").replace("[", "").replace("]", "").trim().toUpperCase();
//	}

}
