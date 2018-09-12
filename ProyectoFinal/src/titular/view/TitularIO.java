package titular.view;

import java.util.Scanner;
import titular.entity.Titular;
import view.InputTypes;

public class TitularIO {
	
	public static Titular ingresar (Scanner scanner){
		int nroTitular = InputTypes.readInt("Ingrese el n�mero de Titular", scanner);
		int CI = InputTypes.readInt("Ingrese el n�mero de CI", scanner);
		String nombre = InputTypes.readString("Ingrese el nombre del titular", scanner);
		int tel�fono = InputTypes.readInt("Ingrese el n�mero de tel�fono del titular", scanner);
		String direccion = InputTypes.readString("Ingrese la direccion del titular", scanner);
		int NIT = InputTypes.readInt("Ingrese el n�mero de NIT del titular", scanner);
		
		return new Titular(nroTitular , CI, nombre, tel�fono, direccion, NIT);

	}

}
