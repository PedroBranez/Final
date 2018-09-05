package com.marcelo.datos;

import java.util.Scanner;

public class VistaAula {
	
	private Aula aula;
	
	public VistaAula (Scanner entrada){
		
		String numero;
		String bloque;	
		Aula aula;
		System.out.println("Ingrese el número del aula:");
		numero = entrada.next();
		entrada.nextLine();
		System.out.println("Ingrese el bloque donde se encuentre el aula");
		bloque = entrada.next();
		
		aula = new Aula(numero,bloque);
		
		this.aula = aula;
	}

	public Aula getAula() {
		return aula;
	}

	@Override
	public String toString() {
		return "VistaAula [aula=" + aula.toString() + "]";
	}
	
	
	

}
