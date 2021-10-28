package objetos;

public class Equipo {
	
	private String nombre;
	//Me suena raro que el arbitro este asignado en el equipo, lo puse en partido a ver que te parece
	//o entendi como el hortencio lo que pusiste jajajja
	private int [] arbitroAsignado;  
	
	
	/**
	 * Constructor Elias
	 * @param nombre
	 * @param fechas
	 */
	public Equipo(String nombre, int fechas) {
		this.nombre = nombre;
		this.arbitroAsignado = new int [fechas];
	}
	
	
	/**
	 * Constructor Federico
	 * @param nombre
	 */
	public Equipo(String nombre) {
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}


	public int [] getArbitroAsignado() {
		return arbitroAsignado;
	}


	public void setArbitroAsignado(int [] arbitroAsignado) {
		this.arbitroAsignado = arbitroAsignado;
	}
	
	
	public void agregarArbitro(int a, int fecha) {
		arbitroAsignado[fecha] = a;	
	}
}
