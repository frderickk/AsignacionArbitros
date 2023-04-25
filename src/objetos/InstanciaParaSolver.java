package objetos;

import java.util.ArrayList;


public class InstanciaParaSolver {
	
	private Campeonato campeonato;
	private int[][] arbitrosPorEquipos;

	
	/**
	 * Constructor de Campeonato especial para el Solver
	 * @param equipos
	 * @param arbitros
	 */
	public InstanciaParaSolver(Fixture fixture, ArrayList<Equipo> equipos, ArrayList<Arbitro> arbitros) {
		campeonato = new Campeonato(fixture, arbitros, equipos);
		this.arbitrosPorEquipos = new int[getEquipos().size()][getArbitros().size()];
	}
	
	
	//Getter y setters
	public int[][] getArbitrosPorEquipos() {
		return arbitrosPorEquipos;
	}


	public void setArbitrosPorEquipos(int[][] arbitrosPorEquipos) {
		this.arbitrosPorEquipos = arbitrosPorEquipos;
	}


	/**
	 * Clonacion de lista de arbitros
	 * @return
	 */
	public ArrayList<Arbitro> getArbitros() {
		return campeonato.getArbitros();
	}


	/**
	 * Clonacion de lista de equipos
	 * @return
	 */
	public ArrayList<Equipo> getEquipos() {
		return campeonato.getEquipos();
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
		localesYVisitantes(partido, arbitro);
	}


	/**
	 * Metodo que se utiliza en elegirArbitro() para encontrar el índice de los equipos según sean locales o visitantes 
	 * a través de los partidos y se va sumando las veces que un arbitro corresponde al local o al visitante.
	 * @param partido
	 * @param arbitro
	 */
	private void localesYVisitantes(Partido partido, Arbitro arbitro) {
		int posicionDeEquipoLocal = getEquipos().indexOf(partido.getLocal());
		int posicionDeArbitroLocal = getArbitros().indexOf(arbitro);
		int vecesArbitroLocal = vecesArbitroPorEquipo(partido.getLocal(), arbitro);
		arbitrosPorEquipos[posicionDeEquipoLocal][posicionDeArbitroLocal] = vecesArbitroLocal + 1;

		int posicionDeEquipoVisitante = getEquipos().indexOf(partido.getVisitante());
		int posicionDeArbitroVisitante = getArbitros().indexOf(arbitro);
		int vecesArbitroVisitante = vecesArbitroPorEquipo(partido.getVisitante(), arbitro);
		arbitrosPorEquipos[posicionDeEquipoVisitante][posicionDeArbitroVisitante] = vecesArbitroVisitante + 1;
	}

	
	/**
	 * Muestra la cantidad de veces que un arbitro corresponde a un equipo
	 * @param equipo
	 * @param arbitro
	 * @return
	 */
	private int vecesArbitroPorEquipo(Equipo equipo, Arbitro arbitro) {
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
}
