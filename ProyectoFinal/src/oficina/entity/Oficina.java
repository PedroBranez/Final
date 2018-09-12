package oficina.entity;

public class Oficina {
	private int nroOficina;
	private int nroTiular;
	private double dimension;
	private int nroPlanta;
	private String estado;
	
	
	
	public Oficina(int nroOficina, int nroTiular, double dimension, int nroPlanta, String estado) {
		super();
		this.nroOficina = nroOficina;
		this.nroTiular = nroTiular;
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
	public int getNroTiular() {
		return nroTiular;
	}
	public void setNroTiular(int nroTiular) {
		this.nroTiular = nroTiular;
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
		return "Oficina [nroOficina=" + nroOficina + ", nroTiular=" + nroTiular + ", dimension=" + dimension
				+ ", nroPlanta=" + nroPlanta + ", estado=" + estado + "]";
	}
	
}
