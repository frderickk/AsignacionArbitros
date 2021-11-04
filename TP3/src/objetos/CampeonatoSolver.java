package objetos;

import java.util.ArrayList;

public class CampeonatoSolver {
	
	private ArrayList<Arbitro> arbitros;
	private ArrayList<Equipo> equipos;
	private int[][] arbitrosPorEquipos;

	
	/**
	 * Constructor de Campeonato especial para el Solver
	 * @param equipos
	 * @param arbitros
	 */
	public CampeonatoSolver(ArrayList<Equipo> equipos, ArrayList<Arbitro> arbitros) {
		this.arbitros = arbitros;
		this.equipos = equipos;
		this.arbitrosPorEquipos = new int[getEquipos().size()][getArbitros().size()];
	}


	/**
	 * Clonacion de lista de arbitros
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Arbitro> getArbitros() {
		return (ArrayList<Arbitro>) arbitros.clone();
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
	 * Verifica que los equipos existan y acomoda la matriz con los indices de cada elemento
	 * dentro de la lista de arbitros y en los partidos del campeonato
	 * @param partido 
	 * @param arbitro
	 */
	public void elegirArbitro(Partido partido, Arbitro arbitro) {
		if(!getEquipos().contains(partido.getLocal())) {
			throw new IllegalArgumentException(partido.getLocal() + " no existe");
		}
		if(!getEquipos().contains(partido.getVisitante())) {
			throw new IllegalArgumentException(partido.getVisitante() + " no existe");
		}
		if(!getArbitros().contains(arbitro)) {
			throw new IllegalArgumentException(arbitro + " no existe");
		}
		cantidadDeVecesLocalesYVisitantes(partido, arbitro);
	}
	
	
	/**
	 * Muestra la cantidad de veces que un arbitro corresponde a un equipo
	 * @param equipo
	 * @param arbitro
	 * @return
	 */
	public int vecesArbitroPorEquipo(Equipo equipo, Arbitro arbitro) {
		if(!getEquipos().contains(equipo)) {
			throw new IllegalArgumentException(equipo + " no existe");
		}
		if(!getArbitros().contains(arbitro)) {
			throw new IllegalArgumentException(arbitro + " no existe");
		}
		int posicionDeEquipo = getEquipos().indexOf(equipo);
		int posicionDeArbitro = getArbitros().indexOf(arbitro);
		return arbitrosPorEquipos[posicionDeEquipo][posicionDeArbitro];
	}


	/**
	 * Metodo que se usa en elegirArbitro para asignar correctamente en la matriz
	 * @param partido
	 * @param arbitro
	 */
	private void cantidadDeVecesLocalesYVisitantes(Partido partido, Arbitro arbitro) {
		int posicionDeEquipoLocal = getEquipos().indexOf(partido.getLocal());
		int posicionDeArbitroLocal = getArbitros().indexOf(arbitro);
		int vecesArbitroLocal = vecesArbitroPorEquipo(partido.getLocal(), arbitro);
		arbitrosPorEquipos[posicionDeEquipoLocal][posicionDeArbitroLocal] = vecesArbitroLocal + 1;

		int posicionDeEquipoVisitante = getEquipos().indexOf(partido.getVisitante());
		int posicionDeArbitroVisitante = getArbitros().indexOf(arbitro);
		int vecesArbitroVisitante = vecesArbitroPorEquipo(partido.getVisitante(), arbitro);
		arbitrosPorEquipos[posicionDeEquipoVisitante][posicionDeArbitroVisitante] = vecesArbitroVisitante + 1;
	}

	
	@Override
	public String toString() {
		return "Arbitros " + arbitros + "y equipos " + equipos + " del Campeonato";
	}
}
