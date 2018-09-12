package view;

import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
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
			//System.out.println("2. Oficina ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 1) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men� 
	 * @throws SQLException 
	 * @throws ClassNotFoundException *
	 ****************************/

	public static void men�(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		Conexi�n conexi�n = new Conexi�n("root","","Edificio");
		TitularesIO titularesIO = new TitularesIO(conexi�n, scanner);
		//ProductosIO productosIO = new ProductosIO(conexi�n, scanner);
		
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
			/*case 2:
				producto.view.Men�.men�(scanner, productosIO);
				break;*/
		
			}
		}
		conexi�n.close();
	}

}
