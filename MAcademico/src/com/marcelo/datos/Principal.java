package com.marcelo.datos;


import java.util.HashSet;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		boolean salir = false;
		Scanner leer = new Scanner(System.in);
		HashSet<Aula> aulas = new HashSet<Aula>();

		while (!salir) {
			switch (Menu.MenuAula(leer)) {
			case 0:
				salir = true;
				break;
			case 1:
				VistaAula vistaAula = new VistaAula(leer);
				aulas.add(vistaAula.getAula());
				break;
			case 2:
				System.out.println("Ingrese el número de Aula: ");
				leer.nextLine();
				String numero = leer.nextLine();
				Aula aulaEncontrada=null;
				for (Aula a : aulas){
					if (a.equals(numero)){
						aulaEncontrada = a;
						break;
					}
				}
				aulas.remove(aulaEncontrada);
			case 3:
				for (Aula aula : aulas){
					System.out.println(aula.toString());
				}
				

			}

		}

		leer.close();

	}

}
