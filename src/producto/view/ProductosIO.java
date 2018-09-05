package producto.view;

import java.util.Scanner;

import categoría.control.Categorías;
import categoría.entity.NoExisteCategoría;
import producto.control.Productos;
import producto.entity.Producto;
import view.InputTypes;

public class ProductosIO {
	private Productos productos;
	private Scanner scanner;
	private Categorías categorías;
	
	
	/****************************
	 * Constructor              *
	 ****************************/
	
	public ProductosIO(Productos productos, Categorías categorías, Scanner scanner) {
		this.productos = productos;
		this.scanner = scanner;
		this.categorías = categorías;
	}

	
	/****************************
	 * Agregar productos        
	 * @throws NoExisteCategoría *
	 ****************************/
	
	public void add() throws NoExisteCategoría  {
		Producto producto = ProductoIO.ingresar(scanner, categorías);
		try {
			productos.ingresar(producto);
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("No existe espacio!");
		}
	}
	
	
	/****************************
	 * Eliminar productos       *
	 ****************************/
	
	public void delete() {
		int codProducto = InputTypes.readInt("Código de producto: ", scanner);
		productos.eliminar(codProducto);
	}

	
	/****************************
	 * Listar productos         *
	 ****************************/
	
	public void list() {
		int codCategoría = 0;
		int índiceCategoría = 0;
		for (int i = 0; i < productos.getCantidad(); i++) {
			System.out.println(productos.getProductos()[i]);
			codCategoría = productos.getProductos()[i].getCodCategoría();
			try {
				índiceCategoría = categorías.buscar(codCategoría);
				System.out.println(categorías.getCategorías()[índiceCategoría]);
			} catch (NoExisteCategoría e) {
				e.printStackTrace();
			}
		}
	}

	/****************************
	 * Devolver vector 			*	
	 * productos         		*
	 ****************************/
	public Productos getProductos() {
		return productos;
	}
	
}
