package inquilino.view;

import java.sql.SQLException;
import java.util.Scanner;

import alquiler.entity.NoExisteAlquiler;
import inquilino.entity.Inquilino;
import inquilino.entity.NoExisteInquilino;
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
			System.out.println("1. Ingresar Inquilino");
			System.out.println("2. Listar Inquilinos ");
			System.out.println("3. Eliminar Inquilino ");
			System.out.println("4. Modificar Inquilino ");
			System.out.println("5. Alquiler por Inquilino ");
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

	public static void menú(Scanner scanner, InquilinosIO inquilinosView) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				inquilinosView.add();
				break;
			case 2:
				inquilinosView.list();
				break;
			case 3:
				try {
					inquilinosView.delete();
				} catch (SQLException e) {
					System.out.println("No existe Inquilino!");
				}
				break;

			case 4:
				try {
					inquilinosView.update();
				} catch (NoExisteInquilino e) {
					System.out.println("No existe inquilino!");
				}
				break;
			case 5:
				try {
					inquilinosView.listAlquiler();
				} catch (NoExisteInquilino e) {
					System.out.println("No existe inquilino!");
				} catch (NoExisteAlquiler e) {
					System.out.println("No existen Alquileres!");
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

	public static void menúModificar(Scanner scanner, Inquilino inquilino) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				inquilino.setCI(InputTypes.readInt("Ingrese el nuevo CI: ", scanner));
				break;
			case 2:
				inquilino.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 3:
				inquilino.setTeléfono(InputTypes.readInt("Ingrese el nuevo Teléfono: ", scanner));
				break;
			case 4:
				inquilino.setDirección(InputTypes.readString("Ingrese la nueva direccíon: ", scanner));
				break;
			case 5:
				inquilino.setNIT(InputTypes.readString("Ingrese el nuevo NIT: ", scanner));
				break;
			}
		}
	}

}
