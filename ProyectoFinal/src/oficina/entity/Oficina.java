package oficina.entity;

public class Oficina {
	private int nroOficina;
	private int nroTitular;
	private String nombre;
	private double dimensi�n;
	private int nroPlanta;
	private String estado;
	
	
	
	public Oficina(int nroOficina, int nroTitular, String nombre, double dimensi�n, int nroPlanta, String estado) {
		super();
		this.nroOficina = nroOficina;
		this.nroTitular = nroTitular;
		this.nombre = nombre;
		this.dimensi�n = dimensi�n;
		this.nroPlanta = nroPlanta;
		this.estado = estado;
		
	}
	public int getNroOficina() {
		return nroOficina;
	}
	public void setNroOficina(int nroOficina) {
		this.nroOficina = nroOficina;
	}
	public int getNroTitular() {
		return nroTitular;
	}
	public void setNroTitular(int nroTiular) {
		this.nroTitular = nroTiular;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getDimensi�n() {
		return dimensi�n;
	}
	public void setDimensi�n(double dimension) {
		this.dimensi�n = dimension;
	}
	public int getNroPlanta() {
		return nroPlanta;
	}
	public void setNroPlanta(int nroPlanta) {
		this.nroPlanta = nroPlanta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Oficina [nroOficina=" + nroOficina + ", nroTitular=" + nroTitular + ", nombre=" + nombre
				+ ", dimensi�n=" + dimensi�n + ", nroPlanta=" + nroPlanta + ", estado=" + estado + "]";
	}
	
}
