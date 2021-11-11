package objetos;

import java.util.ArrayList;


public class Campeonato {
	
	private ArrayList<Arbitro> arbitros;
	private ArrayList<Equipo> equipos;
	private Fixture fixture;

	
	/**
	 * Constructor de campeonato
	 * @param fixture
	 * @param arbitros
	 * @param equipos
	 */
	public Campeonato(Fixture fixture, ArrayList<Arbitro> arbitros, ArrayList<Equipo> equipos) {
		this.arbitros = arbitros;
		this.equipos = equipos;
		this.fixture = fixture;
	}

	
	//Getter y setters
	public Fixture getFixture() {
		return fixture;
	}
	
	
	public void setArbitros(ArrayList<Arbitro> arbitros) {
		this.arbitros = arbitros;
	}
	
	
	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}


	/**
	 * Clonacion de lista de equipos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Equipo> getEquipos() {
		return (ArrayList<Equipo>) equipos.clone();
	}
	
	
	/**
	 * Clonacion de lista de arbitros
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Arbitro> getArbitros() {
		return (ArrayList<Arbitro>) arbitros.clone();
	}

	
	@Override
	public String toString() {
		return "Campeonato [arbitros=" + arbitros + ", equipos=" + equipos + ", fixture=" + fixture + "]";
	}
	
	
}
