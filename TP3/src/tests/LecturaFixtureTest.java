package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import archivos.LecturaFixture;
import objetos.Arbitro;
import objetos.Campeonato;
import objetos.Equipo;
import objetos.Fecha;


public class LecturaFixtureTest {

	@Test
	public void campeonatoLecturTotalTest() {
		Campeonato campeonato = LecturaFixture.nuevoCampeonato(); 
		assertTrue(campeonato != null);
	}
	
	
	@Test
	public void cantidadDeArbitros() {
		Campeonato campeonato = LecturaFixture.nuevoCampeonato();
		ArrayList<Arbitro> arbitros = campeonato.getArbitros();
		assertTrue(arbitros.size() == 10);
	}
	
	
	@Test
	public void cantidadDeEquipos() {
		Campeonato campeonato = LecturaFixture.nuevoCampeonato();
		ArrayList<Equipo> equipos = campeonato.getEquipos();
		assertTrue(equipos.size() == 20);
	}
	
	
	@Test
	public void cantidadDeFechas() {
		Campeonato campeonato = LecturaFixture.nuevoCampeonato();
		ArrayList<Fecha> fechas = campeonato.getFixture().getFechas();
		assertTrue(fechas.size() == 19);	
	}
	
	
	@Test
	public void cantidadDePartidos() {
		Campeonato campeonato = LecturaFixture.nuevoCampeonato();
		ArrayList<Fecha> fechas = campeonato.getFixture().getFechas();
		int partidos = 0;
		for (Fecha fecha : fechas) {
			partidos += fecha.getPartidos().size();
		}
		assertTrue(partidos == 190);	
	}
}
