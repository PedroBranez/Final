package com.marcelo.datos;

import java.util.Scanner;

public class VistaDocente {

	private Docente docente;

	public VistaDocente(Scanner entrada) {

		int codigoDocente;
		String nombre;
		long telefono;
		String direccion;
		Docente docente;
		
			System.out.println("Ingrese el c�digo del docente");
			codigoDocente = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Ingrese el nombre del docente");
			nombre = entrada.next();
			System.out.println("Ingrese el tel�fono del docente");
			telefono = entrada.nextLong();
			System.out.println("Ingrese la direcci�n del docente");
			direccion = entrada.next();

			docente = new Docente(codigoDocente, nombre, telefono, direccion);
			
			this.docente = docente;
		
	}

	@Override
	public String toString() {
		return "VistaDocente [docente=" + docente.toString() + "]";
	}

	
	

}
