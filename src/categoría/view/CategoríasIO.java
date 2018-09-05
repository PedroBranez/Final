package categoría.view;

import java.util.Scanner;

import categoría.control.Categorías;
import categoría.entity.Categoría;
import categoría.entity.NoExisteCategoría;
import producto.control.Productos;
import view.InputTypes;

public class CategoríasIO {
	private Categorías categorías;
	private Scanner scanner;
	private Productos productos;

	
	/****************************
	 * Constructor              
	 * @param productos *
	 ****************************/
	
	public CategoríasIO(Categorías categorías, Productos productos, Scanner scanner) {
		
		this.categorías = categorías;
		this.scanner = scanner;
		this.productos = productos;
	}

	
	/****************************
	 * Agregar categorías        *
	 ****************************/
	
	public void add() {
		Categoría categoría = CategoríaIO.ingresar(scanner);
		try {
			categorías.ingresar(categoría);
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("No existe espacio!");
		}
	}
	
	
	/****************************
	 * Eliminar categorías       
	 * @throws NoExisteCategoría *
	 ****************************/
	
	public void delete() throws NoExisteCategoría {
		int codcategoría = InputTypes.readInt("Código de categoría: ", scanner);
		categorías.eliminar(codcategoría);
	}

	
	/****************************
	 * Listar categorías         *
	 ****************************/
	
	public void list() {
		for (int i = 0; i < categorías.getCantidad(); i++) {
			System.out.println(categorías.getCategorías()[i]);
		}
	}

	
	/****************************
	 * Listar categorías         
	 * @throws NoExisteCategoría *
	 ****************************/
	
	public void listProducts() throws NoExisteCategoría {
		int codCategoría = InputTypes.readInt("Código de categoría: ", scanner);
		System.out.println(categorías.getCategorías()[categorías.buscar(codCategoría)]);
		for (int i = 0; i < productos.getCantidad(); i++) {
			if (codCategoría == productos.getProductos()[i].getCodCategoría()) {
				System.out.println(productos.getProductos()[i]);
			}
		}
	}

	/****************************
	 * Vector de categorías     *
	 ****************************/
	public Categorías getCategorías() {
		return categorías;
	}
	
	
}
