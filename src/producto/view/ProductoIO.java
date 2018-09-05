package producto.view;

import java.util.Scanner;

import categoría.control.Categorías;
import categoría.entity.NoExisteCategoría;
import producto.entity.Producto;
import view.InputTypes;

public class ProductoIO {

	/****************************
	 * Registro de producto 
	 * @throws NoExisteCategoría *
	 ****************************/

	public static Producto ingresar(Scanner scanner,Categorías categorías) throws NoExisteCategoría {
				
		int codProducto = InputTypes.readInt("Ingrese el código del producto", scanner);
		String nombreProducto = InputTypes.readString("Nombre: ", scanner);
		double precio = InputTypes.readDouble("Precio: ", scanner);
		String descripción = InputTypes.readString("Descripción: ", scanner);
		
		
		
		int codCategoría = InputTypes.readInt("Código Categoría: ", scanner);
		
		categorías.buscar(codCategoría);
		
		return new Producto(codProducto, nombreProducto, precio, descripción, codCategoría);

	}

}
