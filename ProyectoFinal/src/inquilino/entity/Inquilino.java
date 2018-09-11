package inquilino.entity;

public class Inquilino { 
	private int CI;
	private String nombre;
	private int teléfono;
	private String dirección;
	private int NIT;
	public Inquilino(int cI, String nombre, int teléfono, String dirección, int nIT) {
		super();
		CI = cI;
		this.nombre = nombre;
		this.teléfono = teléfono;
		this.dirección = dirección;
		NIT = nIT;
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
	public int getNIT() {
		return NIT;
	}
	public void setNIT(int nIT) {
		NIT = nIT;
	}
	@Override
	public String toString() {
		return "Inquilino [CI=" + CI + ", nombre=" + nombre + ", teléfono=" + teléfono + ", dirección=" + dirección
				+ ", NIT=" + NIT + "]";
	}

}
