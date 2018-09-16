package titular.view;

import java.sql.SQLException;
import java.util.Scanner;

import oficina.entity.NoExisteOficina;
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
			System.out.println("4. Modificar Titular ");
			System.out.println("5. Oficinas por Titular ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
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
					System.out.println("No existe titular!");
				}
				break;

			case 4:
				try {
					titularesView.update();
				} catch (NoExisteTitular e) {
					System.out.println("No existe titular!");
				}
				break;
			case 5:
				try {
					titularesView.listOficinas();
				} catch (NoExisteTitular e) {
					System.out.println("No existe titular!");
				} catch (NoExisteOficina e) {
					System.out.println("No existen oficinas!");
				}
				break;
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
			System.out.println("1. Modificar CI");
			System.out.println("2. Modificar Nombre ");
			System.out.println("3. Modificar Teléfono ");
			System.out.println("4. Modificar Dirección ");
			System.out.println("5. Modificar NIT ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void menúModificar(Scanner scanner, Titular titular) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				titular.setCI(InputTypes.readInt("Ingrese el nuevo CI: ", scanner));
				break;
			case 2:
				titular.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 3:
				titular.setTeléfono(InputTypes.readInt("Ingrese el nuevo Teléfono: ", scanner));
				break;
			case 4:
				titular.setDirección(InputTypes.readString("Ingrese la nueva direccíon: ", scanner));
				break;
			case 5:
				titular.setNIT(InputTypes.readString("Ingrese el nuevo NIT: ", scanner));
				break;
			}
		}
	}
}
