package inquilino.view;

import java.sql.SQLException;
import java.util.Scanner;

import alquiler.entity.NoExisteAlquiler;
import inquilino.entity.Inquilino;
import inquilino.entity.NoExisteInquilino;
import view.InputTypes;

public class Men� {

	/****************************
	 * Encabezado del men� *
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

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men� 
	 * @throws SQLException *
	 ****************************/

	public static void men�(Scanner scanner, InquilinosIO inquilinosView) throws SQLException {
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
	 * Encabezado del men� *
	 ****************************/

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar CI");
			System.out.println("2. Modificar Nombre ");
			System.out.println("3. Modificar Tel�fono ");
			System.out.println("4. Modificar Direcci�n ");
			System.out.println("5. Modificar NIT ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void men�Modificar(Scanner scanner, Inquilino inquilino) {
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
				inquilino.setTel�fono(InputTypes.readInt("Ingrese el nuevo Tel�fono: ", scanner));
				break;
			case 4:
				inquilino.setDirecci�n(InputTypes.readString("Ingrese la nueva direcc�on: ", scanner));
				break;
			case 5:
				inquilino.setNIT(InputTypes.readString("Ingrese el nuevo NIT: ", scanner));
				break;
			}
		}
	}

}
