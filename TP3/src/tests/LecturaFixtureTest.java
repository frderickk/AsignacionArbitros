package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import archivos.LecturaFixture;
import objetos.Arbitro;
import objetos.Campeonato;
import objetos.Equipo;
import objetos.Fecha;
import objetos.Fixture;
import objetos.Partido;

public class LecturaFixtureTest {


	@Test
	public void campeonatoNotNullTest() {
		Campeonato campeonato = nuevoCampeonato(); 
		assertTrue(campeonato != null);
	}
	
	
	private Campeonato nuevoCampeonato() {
		return LecturaFixture.leerFixture("Campeonato.json");
	}


}
