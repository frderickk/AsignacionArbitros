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
	public void tournamentNotNullTest() {
		Campeonato tournament = nuevoCampeonato(); 
		assertTrue(tournament != null);
	}
	
	@Test
	public void tournamentCalendarNotNullTest() {
		Campeonato tournament = nuevoCampeonato();
		Fixture calendar = tournament.getFixture();
		assertTrue(calendar != null);
	}
	
	@Test
	public void tournamentRefereesNotNullTest() {
		Campeonato tournament = nuevoCampeonato();
		ArrayList<Arbitro> referees = tournament.getArbitros();
		assertTrue(referees != null);
	}
	
	@Test
	public void tournamentTeamsNotNullTest() {
		Campeonato tournament = nuevoCampeonato();
		ArrayList<Equipo> teams = tournament.getEquipos();
		assertTrue(teams != null);
	}
	
	@Test
	public void tournamentRefereesComplete() {
		Campeonato tournament = nuevoCampeonato();
		ArrayList<Arbitro> referees = tournament.getArbitros();
		assertTrue(referees.size() == 10);
	}
	
	@Test
	public void tournamentTeamsComplete() {
		Campeonato tournament = nuevoCampeonato();
		ArrayList<Equipo> teams = tournament.getEquipos();
		assertTrue(teams.size() == 20);
	}
	
	@Test
	public void tournametMatchDaysComplete() {
		Campeonato tournament = nuevoCampeonato();
		ArrayList<Fecha> gameDays = tournament.getFixture().getFechas();
		assertTrue(gameDays.size() == 19);	
	}
	
	@Test
	public void tournamentMatchesComplete() {
		int matches = 0;
		Campeonato tournament = nuevoCampeonato();
		ArrayList<Fecha> gameDays = tournament.getFixture().getFechas();
		
		for(Fecha gameDay : gameDays) {
			for(@SuppressWarnings("unused") Partido match : gameDay.getPartidos()) {
				matches++;
			}
		}
		assertTrue(matches == 190);
	}
	
	
	private Campeonato nuevoCampeonato() {
		return LecturaFixture.leerFixture("Campeonato.json");
	}


}
