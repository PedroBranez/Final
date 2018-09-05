package producto.view;

import java.util.Scanner;

import categoría.entity.NoExisteCategoría;
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
			System.out.println("1. Ingresar Producto");
			System.out.println("2. Listar Productos ");
			System.out.println("3. Eliminar Producto ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del menú *
	 ****************************/

	public static void menú(Scanner scanner, ProductosIO productosView) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					productosView.add();
				} catch (NoExisteCategoría e) {
					System.out.println("*****************************");
					System.out.println("* 	No existe la categoría!	*");
					System.out.println("*****************************");
				}
				break;
			case 2:
				productosView.list();
				break;
			case 3:
				productosView.delete();
				break;

			}
		}
	}
}
