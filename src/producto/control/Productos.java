package producto.control;

import producto.entity.Producto;

public class Productos {

	private Producto[] productos;
	private int cantidad;
	private int último;

	public Productos(int tamaño) {
		productos = new Producto[tamaño];
		cantidad = 0;
		último = -1;
	}

	/****************************
	 * Ingresar un producto     *
	 ****************************/
	
	public void ingresar(Producto producto) throws  java.lang.ArrayIndexOutOfBoundsException{
		
		productos[++último] = producto;
		cantidad++;
	}

	/****************************
	 * Devuelve la cantidad de  *
	 * elementos                *
	 ****************************/
	
	
	public int getCantidad() {
		return cantidad;
	}
	

	/****************************
	 * Eliminar un producto     *
	 ****************************/
	
	public void eliminar(int codProducto) {
		int índice;
		índice = buscar(codProducto);

		if (índice > -1) {
			if (índice != último) {
				for (int i = índice; i <= último; i++) {
					productos[i] = productos[i + 1];
				}
			}
			último--;
			cantidad--;
		}
	}
	
	
	/****************************
	 * Buscar un   producto     *
	 ****************************/

	private int buscar(int codProducto) {
		int índice = -1;
		for (int i = 0; i <= último; i++) {
			if (codProducto == productos[i].getCodProducto()) {
				índice = i;
			}
		}
		return índice;
	}
	
	
	/****************************
	 * Devuelve el vector de    * 
	 * productos                *
	 ****************************/

	public Producto[] getProductos() {
		return productos;
	}
}
