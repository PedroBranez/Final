package expensa.view;

import java.sql.SQLException;
import java.util.Scanner;

import expensa.entity.Expensa;
import expensa.entity.NoExisteExpensa;
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
			System.out.println("1. Ingresar Expensa ");
			System.out.println("2. Listar Expensas ");
			System.out.println("3. Eliminar Expensa ");
			System.out.println("4. Modificar Expensa ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men� 
	 * @throws SQLException *
	 ****************************/

	public static void men�(Scanner scanner, ExpensasIO expensasView) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				expensasView.add();
				break;
			case 2:
				expensasView.list();
				break;
			case 3:
				try {
					expensasView.delete();
				} catch (SQLException e) {
					System.out.println("No existe Expensa!");
				}
				break;

			case 4:
				try {
					expensasView.update();
				} catch (NoExisteExpensa e) {
					System.out.println("No existe Expensa!");
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
			System.out.println("1. Modificar Costo Tel�fono ");
			System.out.println("2. Modificar Costo Luz ");
			System.out.println("3. Modificar Costo Agua ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void men�Modificar(Scanner scanner, Expensa expensa) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				expensa.setCostoTel�fono(InputTypes.readDouble("Ingrese el nuevo Costo Tel�fono: ", scanner));
				break;
			case 2:
				expensa.setCostoLuz(InputTypes.readDouble("Ingrese el nuevo Costo Luz: ", scanner));
				break;
			case 3:
				expensa.setCostoAgua(InputTypes.readDouble("Ingrese el nuevo Costo Agua: ", scanner));
				break;
			}
		}
	}

}
