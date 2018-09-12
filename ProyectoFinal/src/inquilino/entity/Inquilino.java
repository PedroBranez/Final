package inquilino.entity;

public class Inquilino { 
	private int nroInquilino;
	private int CI;
	private String nombre;
	private int teléfono;
	private String dirección;
	private String NIT;
	
	public Inquilino(int nroInquilino, int cI, String nombre, int teléfono, String dirección, String nIT) {
		super();
		this.nroInquilino = nroInquilino;
		CI = cI;
		this.nombre = nombre;
		this.teléfono = teléfono;
		this.dirección = dirección;
		this.NIT = nIT;
	}
	
	public int getNroInquilino() {
		return nroInquilino;
	}

	public void setNroInquilino(int nroInquilino) {
		this.nroInquilino = nroInquilino;
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
		return "Inquilino [nroInquilino=" + nroInquilino + ", CI=" + CI + ", nombre=" + nombre + ", teléfono="
				+ teléfono + ", dirección=" + dirección + ", NIT=" + NIT + "]";
	}

}
