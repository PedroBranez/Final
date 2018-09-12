package inquilino.view;

import java.util.Scanner;

import inquilino.entity.Inquilino;
import view.InputTypes;

public class InquilinoIO {
	public static Inquilino ingresar (Scanner scanner){
		int CI = InputTypes.readInt("Ingrese el número de CI", scanner);
		String nombre = InputTypes.readString("Ingrese el nombre del inquilino", scanner);
		int teléfono = InputTypes.readInt("Ingrese el número de teléfono del inquilino", scanner);
		String direccion = InputTypes.readString("Ingrese la direccion del inquilino", scanner);
		int NIT = InputTypes.readInt("Ingrese el número de NIT del inquilino", scanner);
		
		return new Inquilino(0, CI, nombre, teléfono, direccion, NIT);

	}
}
