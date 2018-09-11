package alquiler.entity;

public class Alquiler {

	private int nroAlquiler;
	private String fecha;
	private int CIInquilino;
	public Alquiler(int nroAlquiler, String fecha, int cIInquilino) {
		super();
		this.nroAlquiler = nroAlquiler;
		this.fecha = fecha;
		CIInquilino = cIInquilino;
	}
	public int getNroAlquiler() {
		return nroAlquiler;
	}
	public void setNroAlquiler(int nroAlquiler) {
		this.nroAlquiler = nroAlquiler;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getCIInquilino() {
		return CIInquilino;
	}
	public void setCIInquilino(int cIInquilino) {
		CIInquilino = cIInquilino;
	}
	@Override
	public String toString() {
		return "Alquiler [nroAlquiler=" + nroAlquiler + ", fecha=" + fecha + ", CIInquilino=" + CIInquilino + "]";
	}	
	
}
