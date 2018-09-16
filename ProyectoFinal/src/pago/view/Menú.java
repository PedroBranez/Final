package pago.view;

import java.sql.SQLException;
import java.util.Scanner;

import pago.entity.NoExistePago;
import pago.entity.Pago;
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
			System.out.println("1. Ingresar Pago");
			System.out.println("2. Listar pagos ");
			System.out.println("3. Eliminar Pago ");
			System.out.println("4. Modificar Pago ");
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
	 * 
	 * @throws SQLException *
	 ****************************/

	public static void men�(Scanner scanner, PagosIO pagosView) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				pagosView.add();
				break;
			case 2:
				pagosView.list();
				break;
			case 3:
				try {
					pagosView.delete();
				} catch (SQLException e) {
					System.out.println("No existe Pago!");
				}
				break;

			case 4:
				try {
					pagosView.update();
				} catch (NoExistePago e) {
					System.out.println("No existe pago!");
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
			System.out.println("1. Modificar numero de alquiler");
			System.out.println("2. Modificar fecha de pago ");
			System.out.println("3. Modificar Monto a pagar ");
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

	public static void men�Modificar(Scanner scanner, Pago pago) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				pago.setNroAlquiler(InputTypes.readInt("Ingrese el nuevo Numero de Alquiler: ", scanner));
				break;
			case 2:
				pago.setFechaPago(InputTypes.readString("Ingrese la nueva fecha de pago: ", scanner));
				break;
			case 3:
				pago.setMonto(InputTypes.readDouble("Ingrese el nuevo Monto : ", scanner));
				break;
			}
		}
	}

}
