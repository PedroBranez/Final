package view;

import java.util.Scanner;

import categoría.control.Categorías;
import categoría.view.CategoríasIO;
import producto.control.Productos;
import producto.view.ProductosIO;
import view.InputTypes;

public class Menú {

	/****************************
	 * Encabezado del menú *
	 ****************************/

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Categoría");
			System.out.println("2. Producto ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del menú *
	 ****************************/

	public static void menú(Scanner scanner) {
		boolean salir = false;
		
		Categorías categorías = new Categorías(10);
		Productos productos = new Productos(10);

		CategoríasIO categoríasIO = new CategoríasIO(categorías, productos, scanner);
		ProductosIO productosIO = new ProductosIO(productos, categorías, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				categoría.view.Menú.menú(scanner, categoríasIO);
				break;
			case 2:
				producto.view.Menú.menú(scanner, productosIO);
				break;
		
			}
		}
	}
}
