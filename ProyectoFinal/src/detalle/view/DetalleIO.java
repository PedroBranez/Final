package detalle.view;

import java.util.Scanner;

import detalle.entity.Detalle;
import view.InputTypes;

public class DetalleIO {
	public static Detalle ingresar(Scanner scanner) {
		
	
	int nroAlquiler = InputTypes.readInt("Ingrese el número de Alquiler", scanner);
	int nroOficina = InputTypes.readInt("Ingrese el número de Oficina", scanner);
	int precioOficina = InputTypes.readInt("Ingrese el precio de la Oficina", scanner);
	
	return new Detalle(nroAlquiler, nroOficina, precioOficina);
}}
