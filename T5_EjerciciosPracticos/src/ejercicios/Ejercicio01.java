package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {

		char tablero[] = new char[funciones.TAMANIO];
		char tableroJuego[] = new char[funciones.TAMANIO];
		int casilla;
		int resultado = 0;

		Scanner sc = new Scanner(System.in);

		tablero = funciones.rellenaMinas(tablero);

		for (int i = 0; i < funciones.TAMANIO; i++) {
			tableroJuego[i] = '-';
		}

		System.out.println(Arrays.toString(tableroJuego));
		
		do {
			do {
				System.out.println("Introduzca una casilla que destapar (0-19): ");
				casilla = sc.nextInt();
			} while (casilla < 0 || casilla >= 20);
			
			resultado++;
			
			System.out.println(Arrays.toString(funciones.juego(tableroJuego, tablero, casilla)));
		} while (!funciones.fin(tablero, casilla));
		
		if(resultado <= 13) {
			System.out.println("¡Vaya, has perdido! Este es el tablero completo: ");
		}
		else {
			System.out.println("¡Wow, has ganado! Aquí estaban escondidas las bombas: ");
		}
		
		System.out.println(Arrays.toString(tablero));
		
		sc.close();
	}
}