package categoría.view;

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
			System.out.println("1. Ingresar Categoría");
			System.out.println("2. Listar Categorías ");
			System.out.println("3. Eliminar Categoría ");
			System.out.println("4. Productos por Categoría ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del menú *
	 ****************************/

	public static void menú(Scanner scanner, CategoríasIO categoríasView) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				categoríasView.add();
				break;
			case 2:
				categoríasView.list();
				break;
			case 3:
				try {
					categoríasView.delete();
				} catch (NoExisteCategoría e) {
					System.out.println("No existe categoría!");
				}
				break;

			case 4:
				try {
					categoríasView.listProducts();
				} catch (NoExisteCategoría e) {
					System.out.println("No existe categoría!");
				}
				break;
			}
		}
	}
}
