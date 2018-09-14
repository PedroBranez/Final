package view;

import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import detalle.view.DetallesIO;
import expensa.view.ExpensasIO;
import inquilino.view.InquilinosIO;
import oficina.view.OficinasIO;
import titular.view.TitularesIO;

public class Menú {
	/****************************
	 * Encabezado del menú *
	 ****************************/

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Titular");
			System.out.println("2. Oficina ");
			System.out.println("3. Expensa ");
			System.out.println("4. Detalle ");
			System.out.println("5. Inquilino ");
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
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException *
	 ****************************/

	public static void menú(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;

		Conexión conexión = new Conexión("root", "", "Edificio");
		TitularesIO titularesIO = new TitularesIO(conexión, scanner);
		OficinasIO oficinasIO = new OficinasIO(conexión, scanner);
		ExpensasIO expensasIO = new ExpensasIO(conexión, scanner);
		DetallesIO detallesIO = new DetallesIO(conexión, scanner);
		InquilinosIO inquilinosIO = new InquilinosIO(conexión, scanner);

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					titular.view.Menú.menú(scanner, titularesIO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					oficina.view.Menú.menú(scanner, oficinasIO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					expensa.view.Menú.menú(scanner, expensasIO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					detalle.view.Menú.menú(scanner, detallesIO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					inquilino.view.Menú.menú(scanner, inquilinosIO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		conexión.close();
	}

}
