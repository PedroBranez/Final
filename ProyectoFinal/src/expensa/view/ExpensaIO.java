package expensa.view;

import java.util.Scanner;

import expensa.entity.Expensa;
import view.InputTypes;

public class ExpensaIO {
	public static Expensa ingresar (Scanner scanner){
		int nroOficina = InputTypes.readInt("Ingrese el n�mero de Oficina", scanner);
		double costoTel�fono = InputTypes.readDouble("Ingrese el costo de telefono", scanner);
		double costoLuz = InputTypes.readDouble("Ingrese el costo de Luz", scanner);
		double costoAgua = InputTypes.readDouble("Ingrese el costo de Agua", scanner);
		
		return new Expensa(nroOficina, costoTel�fono, costoLuz, costoAgua);

	}

}
