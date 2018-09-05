package com.marcelo.datos;

import java.util.Scanner;

public class VistaMateria {
	
	private Materia materia;
	
	public VistaMateria(Scanner entrada){
		
		int codigoMateria;
		String nombre;
		String descripcion;
		Materia materia;
		
			System.out.println("Ingrese el código de la materia:");
			codigoMateria = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Ingrese el nombre de la materia:");
			nombre = entrada.next();
			System.out.println("Ingrese la descripción de la materia:");
			descripcion = entrada.next();
	
			materia = new Materia(codigoMateria, nombre, descripcion);
			
			this.materia = materia;
	}

	public Materia getMateria() {
		return materia;
	}

	@Override
	public String toString() {
		return "VistaMateria [materia=" + materia.toString() + "]";
	}
	
	

}
