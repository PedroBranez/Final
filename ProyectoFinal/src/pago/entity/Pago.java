package pago.entity;

public class Pago {
	private int nroPago;
	private int nroAlquiler;
	private String fechaPago;
	private double monto;
	
	public Pago(int nroPago, int nroAlquiler, String fechaPago, double monto) {
		super();
		this.nroPago = nroPago;
		this.nroAlquiler = nroAlquiler;
		this.fechaPago = fechaPago;
		this.monto = monto;
	}

	public int getNroPago() {
		return nroPago;
	}

	public void setNroPago(int nroPago) {
		this.nroPago = nroPago;
	}

	public int getNroAlquiler() {
		return nroAlquiler;
	}

	public void setNroAlquiler(int nroAlquiler) {
		this.nroAlquiler = nroAlquiler;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Pago [nroPago=" + nroPago + ", nroAlquiler=" + nroAlquiler + ", fechaPago=" + fechaPago + ", monto="
				+ monto + "]";
	}
	
}
