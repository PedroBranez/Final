package oficina.entity;

public class Oficina {
	private int nroOficina;
	private double dimension;
	private int nroPlanta;
	private int nroAlquiler;
	
	public Oficina(int nroOficina, double dimension, int nroPlanta, int nroAlquiler) {
		
		this.nroOficina = nroOficina;
		this.dimension = dimension;
		this.nroPlanta = nroPlanta;
		this.nroAlquiler = nroAlquiler;
	}
	public int getNroOficina() {
		return nroOficina;
	}
	public void setNroOficina(int nroOficina) {
		this.nroOficina = nroOficina;
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
	public int getNroAlquiler() {
		return nroAlquiler;
	}
	public void setNroAlquiler(int nroAlquiler) {
		this.nroAlquiler = nroAlquiler;
	}
	
	
	@Override
	public String toString() {
		return "Oficina [nroOficina=" + nroOficina + ", dimension=" + dimension + ", nroPlanta=" + nroPlanta
				+ ", nroAlquiler=" + nroAlquiler + "]";
	}
}
