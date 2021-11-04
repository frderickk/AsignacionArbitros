package objetos;

public class Partido {

	private Equipo local;
	private Equipo visitante;
	private Arbitro arbitro;

	
	/**
	 * Constructor de partidos
	 * @param equipo local
	 * @param equipo visitante
	 * @param arbitro
	 */
	public Partido(Equipo local, Equipo visitante) {
		this.local = local;
		this.visitante = visitante;
		this.arbitro = null;
	}

	
	//Getters de equipos y arbitro, setter de arbitro
	public Equipo getLocal() {
		return local;
	}

	
	public Equipo getVisitante() {
		return visitante;
	}


	public Arbitro getArbitro() {
		return arbitro;
	}


	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}


	@Override
	public String toString() {
		return "" + local + " vs " + visitante + ", Arbitro: " + arbitro;
	}

}
