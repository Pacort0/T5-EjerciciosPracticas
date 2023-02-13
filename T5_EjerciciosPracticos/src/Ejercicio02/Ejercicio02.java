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
		String cartas[] = new String[0]; // Guardaremos todas las cartas que se vayan usando
		double jug1 = 0; // Para llevar la cuenta de los puntos del jug1
		double jug2 = 0; // Para llevar la cuenta de los puntos del jug2
		double valorRonda = 0; // Guardaremos el valor de la carta en cada ronda
		char eleccion; // Para guardar la elección del jugador (si quiere o no otra carta)
		String carta; // Guardaremos la carta por escrito

		Scanner sc = new Scanner(System.in);

		funciones.rellenaValores(valores); // Le damos valores a cada carta según su número

		System.out.println("Bienvenidos al juego de la Siete y Media");

		System.out.println("El es turno del JUGADOR 1.");

		do { // Mientras la elección sea 's', se piden más cartas
			do { // Se pedirá al jugador que escoja mientras la respuesta no esté prevista
				System.out.println("¿Deseas sacar una carta? (s/n): ");
				eleccion = sc.next().charAt(0); // Guardamos la elección del jugador
			} while (eleccion != 'n' && eleccion != 's');

			if (eleccion == 'n') { // Si se escoge 'n', se sale de bucle do-while
				break;
			}

			do { // Mientras la carta no se haya sacado ya
				valorRonda = funciones.puntos(valores); // Escogemos una carta aleatoriamente y guardamos su valor
				carta = funciones.carta(valorRonda); // Escogemos aleatoriamente el palo de la carta
			} while (funciones.cartaRepe(carta, cartas));
			
			jug1 += valorRonda; // Sumamos los puntos a los del jugador
			cartas = funciones.gastaCarta(carta, cartas); // Si la carta no se ha repetido, guardamos su valor en el
															// array

			System.out.println("Su carta es " + carta); // Mostramos la carta
			System.out.println("Tienes " + jug1 + " puntos."); // Mostramos los puntos del jugador1

			if (funciones.pasao(jug1)) {
				System.out.println("¡Te has pasado!"); // Si el jugador se ha pasado de los 7.5, se acaba el turno.
				break;
			}

		} while (eleccion == 's');

		System.out.println("Es el turno del JUGADOR 2."); // Se repite el mismo código para el jug2

		do {
			do {
				System.out.println("¿Deseas sacar una carta? (s/n): ");
				eleccion = sc.next().charAt(0);
			} while (eleccion != 'n' && eleccion != 's');

			if (eleccion == 'n') {
				break;
			}

			do {
				valorRonda = funciones.puntos(valores);
				carta = funciones.carta(valorRonda);
			} while (funciones.cartaRepe(carta, cartas));
			
			jug2 += valorRonda;
			cartas = funciones.gastaCarta(carta, cartas);

			System.out.println("Su carta es " + carta);
			System.out.println("Tienes " + jug2 + " puntos.");

			if (funciones.pasao(jug2)) {
				System.out.println("¡Te has pasado!");
				break;
			}

		} while (eleccion == 's');

		funciones.ganador(jug1, jug2); // Mostramos el resultado de la partida

		sc.close(); // Cerramos el escáner
	}

}