package oficina.view;

import java.sql.SQLException;
import java.util.Scanner;
import oficina.entity.NoExisteOficina;
import oficina.entity.Oficina;
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
			System.out.println("1. Ingresar Oficina");
			System.out.println("2. Listar Oficinas ");
			System.out.println("3. Eliminar Oficina ");
			System.out.println("4. Modificar Oficina ");
			System.out.println("5. Oficinas por Estado");
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

	public static void menú(Scanner scanner, OficinasIO oficinasView) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				oficinasView.add();
				break;
			case 2:
				oficinasView.list();
				break;
			case 3:
				try {
					oficinasView.delete();
				} catch (SQLException e) {
					System.out.println("No existe Oficina!");
				}
				break;

			case 4:
				try {
					oficinasView.update();
				} catch (NoExisteOficina e) {
					System.out.println("No existe Oficina!");
				}
				break;
			case 5:
				try {
					oficinasView.listOficinasEstado();
				} catch (NoExisteOficina e) {
					System.out.println("No existen Oficinas!");
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
			System.out.println("1. Modificar numero de Titular");
			System.out.println("2. Modificar nombre");
			System.out.println("3. Modificar dimension ");
			System.out.println("4. Modificar numero de Planta ");
			System.out.println("5. Modificar Estado ");
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

	public static void menúModificar(Scanner scanner, Oficina oficina) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				oficina.setNroTitular(InputTypes.readInt("Ingrese el nuevo nroTitulat: ", scanner));
				break;
			case 2:
				oficina.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 3:
				oficina.setDimensión(InputTypes.readDouble("Ingrese la nueva dimensión: ", scanner));
				break;
			case 4:
				oficina.setNroPlanta(InputTypes.readInt("Ingrese el nuevo Número de Planta: ", scanner));
				break;
			case 5:
				oficina.setEstado(InputTypes.readString("Ingrese el nuevo estado: ", scanner));
				break;
			
			}
		}
	}

}
