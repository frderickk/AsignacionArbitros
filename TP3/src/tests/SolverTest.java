package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import archivos.LecturaFixture;
import objetos.Campeonato;
import objetos.Partido;
import solver.Solver;


public class SolverTest {

	@Test
	public void elegirArbitroCorrectoTest() {
		Campeonato campeonato = LecturaFixture.nuevoCampeonato();
		Partido partido1 = campeonato.getFixture().getFechas().get(0).getPartidos().get(0);
		Partido partido2 = campeonato.getFixture().getFechas().get(0).getPartidos().get(1);
		Solver.fixtureEquilibrado(campeonato);
		assertTrue(partido1.getArbitro().getCodigo() != partido2.getArbitro().getCodigo());
	}
}
