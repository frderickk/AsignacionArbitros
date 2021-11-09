package solver;

import java.util.ArrayList;
import java.util.Random;
import objetos.Arbitro;
import objetos.Campeonato;
import objetos.CampeonatoSolver;
import objetos.Fecha;
import objetos.Fixture;
import objetos.Partido;


public class Solver {
	
	private static CampeonatoSolver campeonato;
	private static Fixture fixture;
	
	
	/**
	 * Inicializador del Solver
	 * @param campeonato
	 * @param fixture del campeonato
	 */
	public static void inicializarSolver(CampeonatoSolver c, Fixture f) {
		campeonato = c;
		fixture = f;
	}
	
	
	/**
	 * Asigna en el fixture a los arbitros
	 * @param campeonato especial para el Solver
	 * @param fixture del campeonato
	 * @return
	 */
	public static Fixture asignar(CampeonatoSolver c, Fixture f) {
		inicializarSolver(c, f);
		Random random = new Random();
		Fixture aux = new Fixture(fixture.getFechas());
		ArrayList<Fecha> fechas = fixture.getFechas();
		Arbitro arbitroAux = new Arbitro(0, null);
		for (Fecha fecha : fechas) {
			ArrayList<Arbitro> arbitros = campeonato.getArbitros();
			for (Partido p : fecha.getPartidos()) {
				int arbitroAleatorio = random.nextInt(arbitros.size());
				arbitroAux = arbitros.get(arbitroAleatorio);
				campeonato.elegirArbitro(p, arbitroAux);
				p.setArbitro(arbitroAux);
				arbitros.remove(arbitroAux);
			}
		}
		aux.setFechasDelTorneo(fechas);
		return aux;
	}
	
	
	/**
	 * Equilibra el campeonato con el Solver en el campeonato
	 * @param campeonato
	 * @return
	 */
	public static Fixture fixtureEquilibrado(Campeonato c) {
		campeonato = new CampeonatoSolver(c.getFixture(), c.getEquipos(), c.getArbitros());
		return Solver.asignar(campeonato, c.getFixture());
	}

}
