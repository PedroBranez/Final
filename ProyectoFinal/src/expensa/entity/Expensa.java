package expensa.entity;

public class Expensa {
	private int nroOficina;
	private double costoTeléfono;
	private double costoLuz;
	private double costoAgua;
	public Expensa(int nroOficina, double costoTelefono, double costoLuz, double costoAgua) {
		super();
		this.nroOficina = nroOficina;
		this.costoTeléfono = costoTelefono;
		this.costoLuz = costoLuz;
		this.costoAgua = costoAgua;
	}
	public int getNroOficina() {
		return nroOficina;
	}
	public void setNroOficina(int nroOficina) {
		this.nroOficina = nroOficina;
	}
	public double getCostoTeléfono() {
		return costoTeléfono;
	}
	public void setCostoTeléfono(double costoTelefono) {
		this.costoTeléfono = costoTelefono;
	}
	public double getCostoLuz() {
		return costoLuz;
	}
	public void setCostoLuz(double costoLuz) {
		this.costoLuz = costoLuz;
	}
	public double getCostoAgua() {
		return costoAgua;
	}
	public void setCostoAgua(double costoAgua) {
		this.costoAgua = costoAgua;
	}
	@Override
	public String toString() {
		return "Expensa [nroOficina: " + nroOficina + ", costoTelefono: " + costoTeléfono + ", costoLuz: " + costoLuz
				+ ", costoAgua: " + costoAgua + "]";
	}
	
}
