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


	public ArrayList<Integer> getArbitros() {
		ArrayList<Integer> codigoDeArbitro = new ArrayList<Integer>();
		for (Arbitro arbitro : this.arbitros) {
			codigoDeArbitro.add(arbitro.getCodigo());
		}
		return codigoDeArbitro;
	}


	public ArrayList<String> getEquipos() {
		ArrayList<String> nombreDeEquipos = new ArrayList<String>();
		for (Equipo equipo : this.equipos) {
			nombreDeEquipos.add(equipo.getNombre());
		}
		return nombreDeEquipos;
	}


	public Fixture getFixture() {
		return fixture;
	}


	@Override
	public String toString() {
		return "Campeonato [arbitros=" + arbitros + ", equipos=" + equipos + ", fixture=" + fixture + "]";
	}
	
	
}
