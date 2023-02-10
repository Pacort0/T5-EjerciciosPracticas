package Ejercicio02;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		double valores[] = new double[10];
		double jug1 = 0;
		double jug2 = 0;
		char eleccion;
		double valorRonda = 0;
		String carta;

		Scanner sc = new Scanner(System.in);

		funciones.rellenaValores(valores);

		System.out.println(Arrays.toString(valores));

		System.out.println("El es turno del JUGADOR 1.");
		do {
			do {
				System.out.println("¿Deseas sacar una carta? (s/n): ");
				eleccion = sc.next().charAt(0);
			} while (eleccion != 'n' && eleccion != 's');
			
			if (eleccion == 'n') {
				break;
			}
			
			valorRonda = funciones.puntos(valores);
			jug1 += valorRonda;
			
			carta = funciones.carta(valorRonda);

			System.out.println("Su carta es " + carta);
			System.out.println("Tienes " + jug1 + " puntos.");
			
			if(funciones.pasao(jug1)) {
				System.out.println("¡Te has pasado!");
				break;
			}

		} while (eleccion == 's');
		
		System.out.println("Es el turno del JUGADOR 2.");
		
		do {
			do {
				System.out.println("¿Deseas sacar una carta? (s/n): ");
				eleccion = sc.next().charAt(0);
			} while (eleccion != 'n' && eleccion != 's');
			
			if (eleccion == 'n') {
				break;
			}
			
			valorRonda = funciones.puntos(valores);
			jug2 += valorRonda;

			carta = funciones.carta(valorRonda);

			System.out.println("Su carta es " + carta);
			System.out.println("Tienes " + jug2 + " puntos.");

			if(funciones.pasao(jug2)) {
				System.out.println("¡Te has pasado!");
				break;
			}
			
		} while (eleccion == 's' && jug2 <= 7.5);
		
		funciones.ganador(jug1, jug2);
		
		sc.close();
	}

}
