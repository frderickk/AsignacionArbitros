package objetos;

public class Arbitro {
	
	private int codigo;
	private String nombre;
	
	
	public Arbitro(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	
	public int getCodigo() {
		return codigo;
	}


	public String getNombre() {
		return nombre;
	}
	
}