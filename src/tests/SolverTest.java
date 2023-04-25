package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import archivos.LecturaJson;
import objetos.Campeonato;
import objetos.Fecha;
import objetos.Fixture;
import objetos.Partido;
import solver.Solver;


public class SolverTest {
	
	
	@Test
	public void asignarArbitrosTest() {
		Campeonato campeonato = LecturaJson.nuevoCampeonato();
		Solver.fixtureEquilibrado(campeonato);
		Fixture fixture = campeonato.getFixture();
		for (Fecha f : fixture.getFechas()) {
			for (Partido p : f.getPartidos()) {
				assertTrue(p.getArbitro() != null);
			}
		}
	}

	
	@Test
	public void elegirArbitroDistintoMismaFechaTest() {
		Campeonato campeonato = LecturaJson.nuevoCampeonato();
		Partido partido1 = campeonato.getFixture().getFechas().get(0).getPartidos().get(0);
		Partido partido2 = campeonato.getFixture().getFechas().get(0).getPartidos().get(1);
		Solver.fixtureEquilibrado(campeonato);
		assertTrue(partido1.getArbitro().getCodigo() != partido2.getArbitro().getCodigo());
	}
	
}
