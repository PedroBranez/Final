package pago.view;

import java.util.Scanner;

import pago.entity.Pago;
import view.InputTypes;

public class PagoIO {
	
	public static Pago ingresar(Scanner scanner){
		int nroPago = InputTypes.readInt("Ingrese el número de Pago", scanner);
		int nroAlquiler = InputTypes.readInt("Ingrese el número de Alquiler", scanner);
		String fechaPago = InputTypes.readString("Ingrese la fecha del pago", scanner);
		double monto = InputTypes.readDouble("Ingrese el monto", scanner);
		
		return new Pago(nroPago, nroAlquiler, fechaPago, monto);
	}
}
