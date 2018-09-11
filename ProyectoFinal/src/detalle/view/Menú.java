package detalle.view;

public class Menú {
	private int CI;
	private String nombre;
	private int telefono;
	private String direccion;
	private int NIT;
	public Menú(int cI, String nombre, int telefono, String direccion, int nIT) {
		super();
		CI = cI;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		NIT = nIT;
	}
	public int getCI() {
		return CI;
	}
	public void setCI(int cI) {
		CI = cI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getNIT() {
		return NIT;
	}
	public void setNIT(int nIT) {
		NIT = nIT;
	}
	@Override
	public String toString() {
		return "Menú [CI=" + CI + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion
				+ ", NIT=" + NIT + "]";
	}
	
	

}
