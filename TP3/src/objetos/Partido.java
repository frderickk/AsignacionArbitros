package objetos;
import java.util.Comparator;

public class Partido implements Comparator<Partido> {

	private Equipo local;
	private Equipo visitante;
	private Arbitro arbitro;

	
	/**
	 * Constructor de partidos
	 * @param equipo local
	 * @param equipo visitante
	 * @param arbitro
	 */
	public Partido(Equipo local, Equipo visitante, Arbitro arbitro) {
		this.local = local;
		this.visitante = visitante;
		this.arbitro = arbitro;
	}

	
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
	public int compare(Partido A, Partido B) {
		if(A.getArbitro().getCodigo() == B.getArbitro().getCodigo()) {
			return -1;
		} 
		return 0;
	}

}
