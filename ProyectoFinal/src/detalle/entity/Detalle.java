package detalle.entity;

public class Detalle {
	private int nroDetalle;
	private int nroAlquiler;
	private int nroOficina;
	private double precioOficina;
	
	public Detalle(int nroDetalle, int nroAlquiler, int nroOficina, double precioOficina) {
		super();
		this.nroDetalle = nroDetalle;
		this.nroAlquiler = nroAlquiler;
		this.nroOficina = nroOficina;
		this.precioOficina = precioOficina;
	}

	public int getNroDetalle() {
		return nroDetalle;
	}


	public void setNroDetalle(int nroDetalle) {
		this.nroDetalle = nroDetalle;
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


	public double getPrecioOficina() {
		return precioOficina;
	}


	public void setPrecioOficina(double precioOficina) {
		this.precioOficina = precioOficina;
	}

	@Override
	public String toString() {
		return "Detalle [nroDetalle=" + nroDetalle + ", nroAlquiler=" + nroAlquiler + ", nroOficina=" + nroOficina
				+ ", precioOficina=" + precioOficina + "]";
	}
	
	
}
