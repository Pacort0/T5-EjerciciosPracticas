package Ejercicio02;

import java.util.Scanner;

public class Ejercicio02 {
	/**
	 * Clase main del ejercicio 2. Llamaremos a todas las funciones y seguiremos la
	 * partida desde aquí
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		double valores[] = new double[10]; // Guardaremos los valores de todas las cartas
		String usadas[] = new String[0]; // Guardaremos todas las cartas que se vayan usando
		double valorCarta = 0; // Guardaremos el valor de la carta en cada ronda
		char eleccion; // Para guardar la elección del jugador (si quiere o no otra carta)
		String carta; // Guardaremos la carta por escrito
		int ronda = 1; //Llevar cuenta de la ronda en la que estamos

		Scanner sc = new Scanner(System.in);

		Funciones.rellenaValores(valores); // Le damos valores a cada carta según su número

		System.out.println("Bienvenidos al juego de la Siete y Media");

		while (ronda <= 2) { //Mientras no se juguen las dos rondas
			System.out.println("El es turno del JUGADOR " + ronda);
			
			do { // Mientras la elección sea 's', se piden más cartas
				do { // Se pedirá al jugador que escoja mientras la respuesta no esté prevista
					System.out.println("¿Deseas sacar una carta? (s/n): ");
					eleccion = sc.next().charAt(0); // Guardamos la elección del jugador
				} while (eleccion != 'n' && eleccion != 's');

				if (eleccion == 'n') { // Si se escoge 'n', se sale de bucle do-while
					ronda += 1; //Cambiamos de ronda
					break;
				}

				do { // Mientras la carta no se haya sacado ya
					valorCarta = Funciones.puntos(valores); // Escogemos una carta aleatoriamente y guardamos su valor
					carta = Funciones.carta(valorCarta); // Escogemos aleatoriamente el palo de la carta
				} while (Funciones.cartaRepe(carta, usadas));

				Funciones.sumaPuntaje(ronda, valorCarta);
				usadas = Funciones.gastaCarta(carta, usadas); // Si la carta no se ha repetido, guardamos su valor en el
																// array

				System.out.println("Su carta es " + carta); // Mostramos la carta
				System.out.println("Tienes " + Funciones.puntosJugador(ronda) + " puntos."); // Mostramos los puntos del
																								// jugador

				if (Funciones.pasao(Funciones.puntosJugador(ronda))) {
					System.out.println("¡Te has pasado!"); // Si el jugador se ha pasado de los 7.5, se acaba el turno.
					ronda += 1; //Cambiamos de ronda
					break;
				}

			} while (eleccion == 's');
		}

		Funciones.ganador(Funciones.jug1, Funciones.jug2); // Mostramos el resultado de la partida

		sc.close(); // Cerramos el escáner
	}

}