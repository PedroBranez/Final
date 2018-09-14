package view;

import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import detalle.view.DetallesIO;
import expensa.view.ExpensasIO;
import inquilino.view.InquilinosIO;
import oficina.view.OficinasIO;
import titular.view.TitularesIO;

public class Men� {
	/****************************
	 * Encabezado del men� *
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

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men�
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException *
	 ****************************/

	public static void men�(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;

		Conexi�n conexi�n = new Conexi�n("root", "", "Edificio");
		TitularesIO titularesIO = new TitularesIO(conexi�n, scanner);
		OficinasIO oficinasIO = new OficinasIO(conexi�n, scanner);
		ExpensasIO expensasIO = new ExpensasIO(conexi�n, scanner);
		DetallesIO detallesIO = new DetallesIO(conexi�n, scanner);
		InquilinosIO inquilinosIO = new InquilinosIO(conexi�n, scanner);

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					titular.view.Men�.men�(scanner, titularesIO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					oficina.view.Men�.men�(scanner, oficinasIO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					expensa.view.Men�.men�(scanner, expensasIO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					detalle.view.Men�.men�(scanner, detallesIO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					inquilino.view.Men�.men�(scanner, inquilinosIO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		conexi�n.close();
	}

}
