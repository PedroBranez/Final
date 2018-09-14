package detalle.view;

import java.sql.SQLException;
import java.util.Scanner;

import detalle.entity.Detalle;
import detalle.entity.NoExisteDetalle;
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
			System.out.println("1. Ingresar Detalle ");
			System.out.println("2. Listar Detalles ");
			System.out.println("3. Eliminar Detalle ");
			System.out.println("4. Modificar Detalle ");
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

	public static void men�(Scanner scanner, DetallesIO detallesView) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				detallesView.add();;
				break;
			case 2:
				detallesView.list();
				break;
			case 3:
				try {
					detallesView.delete();
				} catch (SQLException e) {
					System.out.println("No existe Detalle!");
				}
				break;

			case 4:
				try {
					detallesView.update();
				} catch (NoExisteDetalle e) {
					System.out.println("No existe Detalle!");
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
			System.out.println("1. Modificar N�mero Alquiler ");
			System.out.println("2. Modificar N�mero Ofiina ");
			System.out.println("3. Modificar Precio Oficina ");
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

	public static void men�Modificar(Scanner scanner, Detalle detalle) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				detalle.setNroAlquiler(InputTypes.readInt("Ingrese el nuevo N�mero Alquiler: ", scanner));
				break;
			case 2:
				detalle.setNroOficina(InputTypes.readInt("Ingrese el nuevo N�mero Oficina: ", scanner));
				break;
			case 3:
				detalle.setPrecioOficina(InputTypes.readDouble("Ingrese el nuevo Precio Oficina: ", scanner));
				break;
			}
		}
	}
}
