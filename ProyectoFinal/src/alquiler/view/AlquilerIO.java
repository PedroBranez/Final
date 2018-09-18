package alquiler.view;

import java.util.Scanner;

import alquiler.entity.Alquiler;

import view.InputTypes;

public class AlquilerIO {
	public static Alquiler ingresar(Scanner scanner) {
		int nroAlquiler = InputTypes.readInt("Ingrese el número de Alquiler", scanner);
		int nroInquilino = InputTypes.readInt("Ingrese el nro del Inquilino", scanner);
		String fecha = InputTypes.readString("Ingrese la fecha", scanner);
		
		return new Alquiler(nroAlquiler, nroInquilino, fecha);
	}
}
