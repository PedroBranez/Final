package titular.entity;

public class Titular {
	private int nroTitular;
	private int CI;
	private String nombre;
	private int teléfono;
	private String dirección;
	private String NIT;
	
	public Titular(int nroTitular, int cI, String nombre, int teléfono, String dirección, String nIT) {
		super();
		this.nroTitular = nroTitular;
		CI = cI;
		this.nombre = nombre;
		this.teléfono = teléfono;
		this.dirección = dirección;
		this.NIT = nIT;
	}
	
	public int getNroTitular() {
		return nroTitular;
	}

	public void setNroTitular(int nroTitular) {
		this.nroTitular = nroTitular;
	}

	public int getCI() {
		return CI;
	}
	public void setCI(int cI) {
		CI = cI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTeléfono() {
		return teléfono;
	}
	public void setTeléfono(int teléfono) {
		this.teléfono = teléfono;
	}
	public String getDirección() {
		return dirección;
	}
	public void setDirección(String dirección) {
		this.dirección = dirección;
	}
	public String getNIT() {
		return NIT;
	}
	public void setNIT(String nIT) {
		NIT = nIT;
	}

	@Override
	public String toString() {
		return "Titular [nroTitular=" + nroTitular + ", CI=" + CI + ", nombre=" + nombre + ", teléfono=" + teléfono
				+ ", dirección=" + dirección + ", NIT=" + NIT + "]";
	}
	
}
