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

	
	public void setFechasDelTorneo(ArrayList<Fecha> fechasDelTorneo) {
		this.fechasDelTorneo = fechasDelTorneo;
	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<Fecha> getFechas() {
		return (ArrayList<Fecha>) fechasDelTorneo.clone();
	}
}
