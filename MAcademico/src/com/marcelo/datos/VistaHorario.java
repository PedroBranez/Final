package com.marcelo.datos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VistaHorario {

	private Horario horario;
	
	public VistaHorario(Scanner entrada) throws ParseException{
		
		int codigoHorario;
		Date fechaInicio;
		Date fechaFin;
		String fecha;
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Ingrese el código de horario:");
		codigoHorario = entrada.nextInt();
		System.out.println("Ingrese la fecha de Inicio:");
		fecha = entrada.next();
		fechaInicio = formato.parse(fecha);
		System.out.println("Ingrese la fecha de Inicio:");
		fecha = entrada.next();
		fechaFin = formato.parse(fecha);
		
		horario = new Horario(codigoHorario,fechaInicio,fechaFin);
		
	}

	public Horario getHorario() {
		return horario;
	}

	@Override
	public String toString() {
		return "VistaHorario [horario=" + horario.toString() + "]";
	}
	
	
	
	
}
