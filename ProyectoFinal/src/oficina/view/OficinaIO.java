package oficina.view;

import java.util.Scanner;

import oficina.entity.Oficina;
import view.InputTypes;

public class OficinaIO {
	/****************************
	 * Registro de Oficina *
	 ****************************/

	public static Oficina ingresar(Scanner scanner) {
				
		int nroOficina = InputTypes.readInt("Ingrese el n�mero de Oficina", scanner);
		int nroTitular = InputTypes.readInt("N�mero Titular: ", scanner);
		String nombre = InputTypes.readString("Ingresar nombre: ", scanner);
		double dimensi�n = InputTypes.readDouble("Dimensi�n: ", scanner);
		int nroPlanta = InputTypes.readInt("N�mero de Planta: ", scanner);
		String estado = InputTypes.readString("Ingresar estado: ", scanner);
		
		
		return new Oficina(nroOficina, nroTitular, nombre, dimensi�n, nroPlanta, estado);

	}
}
