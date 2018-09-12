package titular.entity;

public class Titular {
	private int nroTitular;
	private int CI;
	private String nombre;
	private int tel�fono;
	private String direcci�n;
	private String NIT;
	
	public Titular(int nroTitular, int cI, String nombre, int tel�fono, String direcci�n, String nIT) {
		super();
		this.nroTitular = nroTitular;
		CI = cI;
		this.nombre = nombre;
		this.tel�fono = tel�fono;
		this.direcci�n = direcci�n;
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
	public int getTel�fono() {
		return tel�fono;
	}
	public void setTel�fono(int tel�fono) {
		this.tel�fono = tel�fono;
	}
	public String getDirecci�n() {
		return direcci�n;
	}
	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
	}
	public String getNIT() {
		return NIT;
	}
	public void setNIT(String nIT) {
		NIT = nIT;
	}

	@Override
	public String toString() {
		return "Titular [nroTitular=" + nroTitular + ", CI=" + CI + ", nombre=" + nombre + ", tel�fono=" + tel�fono
				+ ", direcci�n=" + direcci�n + ", NIT=" + NIT + "]";
	}
	
}
