package com.marcelo.datos;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class VistaAsignacionDocente {

	private AsignacionDocente asignacionDocente;

	public VistaAsignacionDocente(Scanner entrada) {

		int codigoAsignacionDocente;
		int codigoDocente;
		String numeroAula;
		int codigoMateria;
		int codigoHorario;
		Date fecha;
		

		System.out.println("Ingrese el código de la asignación Docente:");
		codigoAsignacionDocente = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Ingrese el código del Docente:");
		codigoDocente = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Ingrese el código del docente:");
		codigoDocente = entrada.nextInt();
		System.out.println("Ingrese el número de aula:");
		numeroAula = entrada.next();
		System.out.println("Ingrese el código de la materia:");
		codigoMateria = entrada.nextInt();
		System.out.println("Ingrese el código del horario:");
		codigoHorario = entrada.nextInt();
		
		Calendar cal = Calendar.getInstance();
		fecha = cal.getTime();
		
		asignacionDocente = new AsignacionDocente(codigoAsignacionDocente, codigoDocente, numeroAula, codigoMateria,
							 codigoHorario, fecha);

		

	}

	public AsignacionDocente getAsignacionDocente() {
		return asignacionDocente;
	}

	@Override
	public String toString() {
		return "VistaAsignacion [asignacionDocente=" + asignacionDocente.toString() + "]";
	}
	
	

}
