package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import archivos.LecturaJson;
import objetos.Arbitro;
import objetos.Campeonato;
import objetos.InstanciaParaSolver;
import objetos.Equipo;
import objetos.Fecha;
import objetos.Partido;


public class CampeonatoTest {

	@Test
	public void campeonatoLecturCorrectaTest() {
		Campeonato campeonato = LecturaJson.nuevoCampeonato(); 
		assertTrue(campeonato != null);
	}
	
	
	@Test
	public void cantidadDeArbitros() {
		Campeonato campeonato = LecturaJson.nuevoCampeonato();
		ArrayList<Arbitro> arbitros = campeonato.getArbitros();
		assertTrue(arbitros.size() == 10);
	}
	
	
	@Test
	public void cantidadDeEquipos() {
		Campeonato campeonato = LecturaJson.nuevoCampeonato();
		ArrayList<Equipo> equipos = campeonato.getEquipos();
		assertTrue(equipos.size() == 20);
	}
	
	
	@Test
	public void cantidadDeFechas() {
		Campeonato campeonato = LecturaJson.nuevoCampeonato();
		ArrayList<Fecha> fechas = campeonato.getFixture().getFechas();
		assertTrue(fechas.size() == 19);	
	}
	
	
	@Test
	public void cantidadDePartidos() {
		Campeonato campeonato = LecturaJson.nuevoCampeonato();
		ArrayList<Fecha> fechas = campeonato.getFixture().getFechas();
		int partidos = 0;
		for (Fecha fecha : fechas) {
			partidos += fecha.getPartidos().size();
		}
		assertTrue(partidos == 190);	
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void equipoYArbitroInexistentes() {
		Campeonato campeonato = LecturaJson.nuevoCampeonato();
		InstanciaParaSolver cs = new InstanciaParaSolver(campeonato.getFixture(), campeonato.getEquipos(), campeonato.getArbitros());
		Equipo e1 = new Equipo("Chacarita");
		Equipo e2 = new Equipo("Quilmes");
		Partido p = new Partido(e1, e2);
		Arbitro a = new Arbitro(11, "Franklin");
		cs.elegirArbitro(p, a);
	}
}
