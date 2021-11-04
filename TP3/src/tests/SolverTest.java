package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import archivos.LecturaFixture;
import objetos.Campeonato;
import objetos.CampeonatoSolver;
import objetos.Partido;
import solver.Solver;

public class SolverTest {

	@Test
	public void elegirArbitroTest() {
		Campeonato campeonato = LecturaFixture.nuevoCampeonato();
		Partido partido = campeonato.getFixture().getFechas().get(0).getPartidos().get(0);
		Solver.fixtureEquilibrado(campeonato);
		assertTrue(partido.getArbitro().getCodigo() == 0);
	}
}
