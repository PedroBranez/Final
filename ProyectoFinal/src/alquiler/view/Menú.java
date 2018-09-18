package alquiler.view;

import java.sql.SQLException;
import java.util.Scanner;

import alquiler.entity.Alquiler;
import alquiler.entity.NoExisteAlquiler;
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
			System.out.println("1. Ingresar Alquiler");
			System.out.println("2. Listar Alquileres ");
			System.out.println("3. Eliminar Alquiler ");
			System.out.println("4. Modificar Alquiler ");
			System.out.println("5. Pagos por Alquiler ");
			System.out.println("6. Detalles por Alquiler ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 6) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del menú 
	 * @throws SQLException *
	 ****************************/

	public static void menú(Scanner scanner, AlquileresIO alquileresView) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				alquileresView.add();
				break;
			case 2:
				alquileresView.list();
				break;
			case 3:
				try {
					alquileresView.delete();
				} catch (SQLException e) {
					System.out.println("No existe alquiler!");
				}
				break;

			case 4:
				try {
					alquileresView.update();
				} catch (NoExisteAlquiler e) {
					System.out.println("No existe alquiler!");
				}
				break;
			case 5:
				try {
					alquileresView.listPagos();
				} catch (NoExisteAlquiler e) {
					System.out.println("No existe alquiler!");
				}
				break;
			case 6:
				try {
					alquileresView.listDetalles();
				} catch (NoExisteAlquiler e) {
					System.out.println("No existe alquiler!");
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
			System.out.println("1. Modificar Número Inquilino");
			System.out.println("2. Modificar Fecha ");
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

	public static void menúModificar(Scanner scanner, Alquiler alquiler) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				alquiler.setNroInquilino(InputTypes.readInt("Ingrese el nuevo Número Inquilino: ", scanner));
				break;
			case 2:
				alquiler.setFecha(InputTypes.readString("Ingrese la nueva Fecha: ", scanner));
				break;
			}
		}
	}
}
