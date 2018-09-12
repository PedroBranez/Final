package titular.view;

import java.sql.SQLException;
import java.util.Scanner;

import titular.entity.NoExisteTitular;
import titular.entity.Titular;
import view.InputTypes;

public class Menú {
	/****************************
	 * Encabezado del menú *
	 ****************************/

	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Titular");
			System.out.println("2. Listar Titulares ");
			System.out.println("3. Eliminar Titular ");
			//System.out.println("4. Modificar Titular ");
			//System.out.println("5. Oficinas por Titular ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del menú 
	 * @throws SQLException *
	 ****************************/

	public static void menú(Scanner scanner, TitularesIO titularesView) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				titularesView.add();
				break;
			case 2:
				titularesView.list();
				break;
			case 3:
				try {
					titularesView.delete();
				} catch (SQLException e) {
					System.out.println("No existe categoría!");
				}
				break;

			/*case 4:
				try {
					titularesView.update();
				} catch (NoExisteCategoría e) {
					System.out.println("No existe categoría!");
				}
				break;

			case 5:
				try {
					titularesView.listProducts();
				} catch (NoExisteCategoría e) {
					System.out.println("No existe categoría!");
				}
				break;*/
			}
		}
	}

	/*****
	 * nuevo
	 */

	/****************************
	 * Encabezado del menú *
	 ****************************/

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar nombre");
			System.out.println("2. Modificar descripción ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	/*public static void menúModificar(Scanner scanner, Titular titular) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				titular.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 2:
				titular.setDescripción(InputTypes.readString("Ingrese la nueva descripcíon: ", scanner));
				break;
			}
		}
	}*/
}
