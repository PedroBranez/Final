package alquiler.entity;

public class Alquiler {

	private int nroAlquiler;
	private int nroInquilino;
	private String fecha;
	
	public Alquiler(int nroAlquiler, int cIInquilino, String fecha ) {
		super();
		this.nroAlquiler = nroAlquiler;
		nroInquilino = cIInquilino;
		this.fecha = fecha;
	}
	public int getNroAlquiler() {
		return nroAlquiler;
	}
	public void setNroAlquiler(int nroAlquiler) {
		this.nroAlquiler = nroAlquiler;
	}
	public int getNroInquilino() {
		return nroInquilino;
	}
	public void setNroInquilino(int cIInquilino) {
		nroInquilino = cIInquilino;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Alquiler [nroAlquiler: " + nroAlquiler + ", nroInquilino: " + nroInquilino + ", fecha: " + fecha + "]";
	}
	
	
}
