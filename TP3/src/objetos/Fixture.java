package objetos;

import java.util.ArrayList;

public class Fixture {
	
	private ArrayList<Fecha> fechasDelTorneo;


	/**
	 * Constructor del fixture con una lista de fechas
	 * @param fechasDelTorneo
	 */
	public Fixture(ArrayList<Fecha> fechasDelTorneo) {
		this.fechasDelTorneo = fechasDelTorneo;
	}

	
	//Setter de fechas
	public void setFechasDelTorneo(ArrayList<Fecha> fechasDelTorneo) {
		this.fechasDelTorneo = fechasDelTorneo;
	}

	
	/**
	 * Clonacion de lista de fechas
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Fecha> getFechas() {
		return (ArrayList<Fecha>) fechasDelTorneo.clone();
	}


	@Override
	public String toString() {
		String fixtureFormateado = fechasDelTorneo.toString().replace(",", "").replace("[", "").replace("]", "").trim();
		return fixtureFormateado;
	}
	
	
}
