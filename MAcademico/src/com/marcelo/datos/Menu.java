package com.marcelo.datos;

import java.util.Scanner;

public class Menu {

	public static int MenuAula(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opción: ");
				System.out.println("------------------- ");
				System.out.println("1. Ingresar Aula ");
				System.out.println("2. Eliminar Aula ");
				System.out.println("3. Listar Aulas ");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				if (opcion >= 0 && opcion <= 3) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

}
