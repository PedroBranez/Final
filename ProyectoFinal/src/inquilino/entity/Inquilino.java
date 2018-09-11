package inquilino.entity;

public class Inquilino { 
	private int CI;
	private String nombre;
	private int tel�fono;
	private String direcci�n;
	private int NIT;
	public Inquilino(int cI, String nombre, int tel�fono, String direcci�n, int nIT) {
		super();
		CI = cI;
		this.nombre = nombre;
		this.tel�fono = tel�fono;
		this.direcci�n = direcci�n;
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
	public int getNIT() {
		return NIT;
	}
	public void setNIT(int nIT) {
		NIT = nIT;
	}
	@Override
	public String toString() {
		return "Inquilino [CI=" + CI + ", nombre=" + nombre + ", tel�fono=" + tel�fono + ", direcci�n=" + direcci�n
				+ ", NIT=" + NIT + "]";
	}

}
