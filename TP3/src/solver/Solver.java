package solver;

import java.util.ArrayList;
import java.util.Random;
import objetos.Arbitro;
import objetos.Campeonato;
import objetos.InstanciaParaSolver;
import objetos.Fecha;
import objetos.Fixture;
import objetos.Partido;


public class Solver {
	
	private static InstanciaParaSolver insCampeonato;
	private static Fixture fixture;
	
	
	/**
	 * Inicializa la instancia para el Solver
	 * @param insCampeonato
	 * @param fixture del campeonato
	 */
	public static void inicializarSolver(InstanciaParaSolver c, Fixture f) {
		insCampeonato = c;
		fixture = f;
	}
	
	
	/**
	 * Asigna en el fixture los árbitros elegidos desde la instancia ya inicializada
	 * @param insCampeonato especial para el Solver
	 * @param fixture del campeonato
	 * @return
	 */
	public static Fixture asignar(InstanciaParaSolver c, Fixture f) {
		inicializarSolver(c, f);
		Random random = new Random();
		Fixture aux = new Fixture(fixture.getFechas());
		ArrayList<Fecha> fechas = fixture.getFechas();
		Arbitro arbitroAux = new Arbitro(0, null);
		for (Fecha fecha : fechas) {
			ArrayList<Arbitro> arbitros = insCampeonato.getArbitros();
			for (Partido p : fecha.getPartidos()) {
				int arbitroAleatorio = random.nextInt(arbitros.size());
				arbitroAux = arbitros.get(arbitroAleatorio);
				insCampeonato.elegirArbitro(p, arbitroAux);
				p.setArbitro(arbitroAux);
				arbitros.remove(arbitroAux);
			}
		}
		aux.setFechasDelTorneo(fechas);
		return aux;
	}
	
	
	/**
	 * Retorna el campeonato pasado como parametro con la asignacion de los arbitros
	 * @param campeonato
	 * @return
	 */
	public static Fixture fixtureEquilibrado(Campeonato c) {
		insCampeonato = new InstanciaParaSolver(c.getFixture(), c.getEquipos(), c.getArbitros());
		return Solver.asignar(insCampeonato, c.getFixture());
	}

}
