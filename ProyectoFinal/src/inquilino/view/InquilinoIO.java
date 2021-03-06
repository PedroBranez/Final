package inquilino.view;

import java.util.Scanner;

import inquilino.entity.Inquilino;
import view.InputTypes;

public class InquilinoIO {
	public static Inquilino ingresar (Scanner scanner){
		int nroInquilino = InputTypes.readInt("Ingrese el n�mero de Inquilino", scanner);
		int CI = InputTypes.readInt("Ingrese el n�mero de CI", scanner);
		String nombre = InputTypes.readString("Ingrese el nombre del inquilino", scanner);
		int tel�fono = InputTypes.readInt("Ingrese el n�mero de tel�fono del inquilino", scanner);
		String direccion = InputTypes.readString("Ingrese la direccion del inquilino", scanner);
		String NIT = InputTypes.readString("Ingrese el n�mero de NIT del inquilino", scanner);
		
		return new Inquilino(nroInquilino, CI, nombre, tel�fono, direccion, NIT);

	}
}
