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

	
	/**
	 * Clonacion de la lista de partidos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Partido> getPartidos() {
		return (ArrayList<Partido>) partidos.clone();
	}

	
	public int numeroDeFecha() {
		return numeroDeFecha;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nFecha: " + numeroDeFecha + "\n");
		for (Partido p: this.partidos) {
			if(p.getArbitro() == null) {
				sb.append(p.getLocal() + " vs " + p.getVisitante() + "\n");
			}
			else {
				sb.append(p.getLocal() + " vs " + p.getVisitante() + " - Arbitro: " + p.getArbitro() + "\n");
			}
		}
		return sb.toString().toUpperCase();
	}
	
}
