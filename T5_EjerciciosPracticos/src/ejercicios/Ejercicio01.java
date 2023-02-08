package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio01 {
	/**
	 * clase main del ejercicio 01
	 * @param args
	 */

	public static void main(String[] args) {
		
		char tablero[] = new char[funciones.TAMANIO]; //Creamos el tablero a rellenar con las pistas
		char tableroJuego[] = new char[funciones.TAMANIO]; //Creamos el tablero con el que se va a jugar
		int casilla; //Para guardar la casilla que el usuario quiere destapar
		int buena = 0; //Según el resultado, imprimiremos una cosa u otra al final del juego

		Scanner sc = new Scanner(System.in); //Escáner del programa

		tablero = funciones.rellenaMinas(tablero); //Rellenamos el tablero

		for (int i = 0; i < funciones.TAMANIO; i++) { //Rellenamos el tablero de juego con guiones
			tableroJuego[i] = '-';
		}
		
		System.out.println(Arrays.toString(tableroJuego)); //Mostramos el tablero de juego
		
		do { //Pedimos al usuario una casilla a destapar mientras éste no se coma una mina
			do { //Pedimos al usuario una casilla válida a destapar
				System.out.println("Introduzca una casilla que destapar (0-19): ");
				casilla = sc.nextInt();
			} while (casilla < 0 || casilla >= 20 || tableroJuego[casilla] != '-');
			
			buena++; //Si logra pasar el segundo do-while, es una casilla válida a destapar, así que aumentamos el contador
			
			System.out.println(Arrays.toString(funciones.juego(tableroJuego, tablero, casilla))); //Mostramos el tablero con la casilla destapada
		} while (!funciones.derrota(tablero, casilla) && !funciones.victoria(buena));
		
		if(funciones.derrota(tablero, casilla)) { //Si el resultado está por debajo de 14, ha perdido
			System.out.println("¡Vaya, has perdido! Este es el tablero completo: ");
		} 
		else { //Si no, ha conseguido terminar el juego sin morir
			System.out.println("¡Wow, has ganado! Aquí estaban escondidas las bombas: ");
		}
		
		System.out.println(Arrays.toString(tablero)); //Mostramos el tablero totalmente relleno
		
		sc.close(); //Cerramos el escáner porque me da TOC
	}
}