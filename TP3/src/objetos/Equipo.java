package objetos;

public class Equipo {
	
	private String nombre;
	private int [] arbitroAsignado;
	
	
	public Equipo(String nombre, int fechas) {
		this.nombre = nombre;
		this.arbitroAsignado = new int [fechas];
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
