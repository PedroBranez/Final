package oficina.view;

import java.util.Scanner;

import oficina.entity.Oficina;
import view.InputTypes;

public class OficinaIO {
	/****************************
	 * Registro de Oficina *
	 ****************************/

	public static Oficina ingresar(Scanner scanner) {
				
		int nroOficina = InputTypes.readInt("Ingrese el número de Oficina", scanner);
		double dimensión = InputTypes.readDouble("Dimensión: ", scanner);
		int nroPlanta = InputTypes.readInt("Número de Planta: ", scanner);
		int nroAlquiler = InputTypes.readInt("Número Alquiler: ", scanner);
		String estado = InputTypes.readString("Ingresar estado", scanner);
		
		return new Oficina(nroOficina, dimensión, nroPlanta, nroAlquiler, estado);

	}
}
