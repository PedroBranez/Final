package alquiler.view;

import java.util.Scanner;

import alquiler.entity.Alquiler;

import view.InputTypes;

public class AlquilerIO {
	public static Alquiler ingresar(Scanner scanner) {
		int nroAlquiler = InputTypes.readInt("Ingrese el número de Alquiler", scanner);
		String fecha = InputTypes.readString("Ingrese la fecha", scanner);
		int CIInquilino = InputTypes.readInt("Ingrese el CI del Inquilino", scanner);
		
		return new Alquiler(nroAlquiler, fecha, CIInquilino);
	}
}
