package producto.entity;

public class Producto {
	
	private int codProducto;
	private String nombre;
	private double precio;
	private String descripción;
	private int codCategoría;
	
	public Producto(int codProducto, String nombre, double precio, String descripción, int codCategoría) {
		this.codProducto = codProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.descripción = descripción;
		this.codCategoría = codCategoría;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public int getCodCategoría() {
		return codCategoría;
	}

	public void setCodCategoría(int codCategoría) {
		this.codCategoría = codCategoría;
	}

	@Override
	public String toString() {
		return "Producto [codProducto=" + codProducto + ", nombre=" + nombre + ", precio=" + precio + ", descripción="
				+ descripción + ", codCategoría=" + codCategoría + "]";
	}
	
	
	

}
