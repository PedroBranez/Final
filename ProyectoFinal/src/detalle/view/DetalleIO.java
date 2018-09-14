package detalle.view;

import java.util.Scanner;

import detalle.entity.Detalle;
import view.InputTypes;

public class DetalleIO {
	public static Detalle ingresar(Scanner scanner) {

		int nroDetalle = InputTypes.readInt("Ingrese el n�mero de Detalle", scanner);
		int nroAlquiler = InputTypes.readInt("Ingrese el n�mero de Alquiler", scanner);
		int nroOficina = InputTypes.readInt("Ingrese el n�mero de Oficina", scanner);
		double precioOficina = InputTypes.readDouble("Ingrese el precio de la Oficina", scanner);

		return new Detalle(nroDetalle, nroAlquiler, nroOficina, precioOficina);
	}
}
