package com.marcelo.datos;

import java.util.Scanner;

public class VistaEstudiante {
	
	private Estudiante estudiante;
	
	public VistaEstudiante(Scanner entrada){
		int codigoEstudiante;
		String nombre;
		long telefono;
		String direccion;
		Estudiante estudiante;
		
			System.out.println("Ingrese el c�digo del estudiante");
			codigoEstudiante = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Ingrese el nombre del estudiante");
			nombre = entrada.next();
			System.out.println("Ingrese el tel�fono del estudiante");
			telefono = entrada.nextLong();
			System.out.println("Ingrese la direcci�n del estudiante");
			direccion = entrada.next();

			estudiante = new Estudiante(codigoEstudiante, nombre, telefono, direccion);
			
			this.estudiante = estudiante;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	@Override
	public String toString() {
		return "VistaEstudiante [estudiante=" + estudiante.toString() + "]";
	}
	
	

}
