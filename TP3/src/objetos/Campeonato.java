package objetos;

import java.util.ArrayList;

public class Campeonato {
	
	private ArrayList<Arbitro> arbitros;
	private ArrayList<Equipo> equipos;
	private Fixture fixture;

	
	public Campeonato(Fixture fixture, ArrayList<Arbitro> arbitros, ArrayList<Equipo> equipos) {
		this.arbitros = arbitros;
		this.equipos = equipos;
		this.fixture = fixture;
	}


	public ArrayList<Arbitro> getArbitros() {
		return arbitros;
	}


	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}


	public Fixture getFixture() {
		return fixture;
	}


	@Override
	public String toString() {
		return "Campeonato [arbitros=" + arbitros + ", equipos=" + equipos + ", fixture=" + fixture + "]";
	}
	
	
}
