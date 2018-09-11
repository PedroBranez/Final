package detalle.entity;

public class Detalle {
	private int nroAlquiler;
	private int nroOficina;
	private int precioOficina;
	public Detalle(int nroAlquiler, int nroOficina, int precioOficina) {
		super();
		this.nroAlquiler = nroAlquiler;
		this.nroOficina = nroOficina;
		this.precioOficina = precioOficina;
	}
	public int getNroAlquiler() {
		return nroAlquiler;
	}
	public void setNroAlquiler(int nroAlquiler) {
		this.nroAlquiler = nroAlquiler;
	}
	public int getNroOficina() {
		return nroOficina;
	}
	public void setNroOficina(int nroOficina) {
		this.nroOficina = nroOficina;
	}
	public int getPrecioOficina() {
		return precioOficina;
	}
	public void setPrecioOficina(int precioOficina) {
		this.precioOficina = precioOficina;
	}
	@Override
	public String toString() {
		return "Detalle [nroAlquiler=" + nroAlquiler + ", nroOficina=" + nroOficina + ", precioOficina=" + precioOficina
				+ "]";
	}
}
