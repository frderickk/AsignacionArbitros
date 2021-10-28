package objetos;

import java.util.ArrayList;

public class Fecha {
	
	private ArrayList<Partido> partidos;
	private int numeroDeFecha;
	
	
	/**
	 * Constructor de una fecha del Torneo
	 * @param Lista de partidos de esa fecha
	 * @param numero de fecha
	 */
	public Fecha(ArrayList<Partido> partidos, int numeroDeFecha) {
		this.partidos = partidos;
		this.numeroDeFecha = numeroDeFecha;
	}

	
	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	
	public int numeroDeFecha() {
		return numeroDeFecha;
	}
}
