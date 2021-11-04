package objetos;

public class Arbitro {
	
	private int codigo;
	private String nombre;
	
	
	/**
	 * Constructor de Arbitro
	 * @param codigo
	 * @param nombre
	 */
	public Arbitro(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	
	//Getters
	public int getCodigo() {
		return codigo;
	}


	public String getNombre() {
		return nombre;
	}


	@Override
	public String toString() {
		return "" + codigo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arbitro other = (Arbitro) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	
	
	
}
