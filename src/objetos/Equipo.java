package objetos;


public class Equipo {
	
	private String nombre;
	
	
	/**
	 * Constructor
	 * @param nombre
	 */
	public Equipo(String nombre) {
		this.nombre = nombre;
	}

	
	//Getter nombre
	public String getNombre() {
		return nombre;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Equipo other = (Equipo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return ""+nombre;
	}

}
