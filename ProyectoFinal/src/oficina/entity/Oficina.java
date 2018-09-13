package oficina.entity;

public class Oficina {
	private int nroOficina;
	private int nroTitular;
	private double dimension;
	private int nroPlanta;
	private String estado;
	
	
	
	public Oficina(int nroOficina, int nroTitular, double dimension, int nroPlanta, String estado) {
		super();
		this.nroOficina = nroOficina;
		this.nroTitular = nroTitular;
		this.dimension = dimension;
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
	public double getDimension() {
		return dimension;
	}
	public void setDimension(double dimension) {
		this.dimension = dimension;
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
		return "Oficina [nroOficina=" + nroOficina + ", nroTitular=" + nroTitular + ", dimension=" + dimension
				+ ", nroPlanta=" + nroPlanta + ", estado=" + estado + "]";
	}
	
}
