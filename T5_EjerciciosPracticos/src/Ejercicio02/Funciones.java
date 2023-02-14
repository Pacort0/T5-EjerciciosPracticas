package Ejercicio02;

import java.util.Arrays;

public class Funciones {

	public static final double maximoPuntos = 7.5; // Variable global para determinar la puntuación límite
	public static double jug1;
	public static double jug2;

	/**
	 * Función que rellena la tabla valores con los valores de las cartas
	 * 
	 * @param valores Recibe la tabla valores vacía
	 */
	public static void rellenaValores(double[] valores) {

		for (int i = 0; i < valores.length; i++) {
			if (i >= 7) { // Los índices 7, 8 y 9 corresponden a la sota, el caballo y el rey
				valores[i] = 0.5;
			} else {
				valores[i] = (i + 1);
			}
		}
	}

	/**
	 * Función que escoge aleatoriamente el valor de la carta en cada turno
	 * 
	 * @param valores Recibe la tabla con los valores
	 * @return Devuelve los puntos de la carta
	 */
	public static double puntos(double[] valores) {
		double valoresCartas;

		valoresCartas = (Math.random() * (10) - 1); // Escoge el número de la carta
		valoresCartas = valores[(int) valoresCartas]; // Inserta el valor de la carta en la variable

		return valoresCartas;
	}
	
	/**
	 * Función que suma la puntuación de los jugadores
	 * @param ronda Recibe el jugador que está jugando la ronda
	 * @param valorCarta Recibe el valor de la carta
	 */
	public static void sumaPuntaje(int ronda, double valorCarta) {
		
		if(ronda == 1) {
			jug1 += valorCarta;
		}
		else {
			jug2 += valorCarta;
		}
	}
	
	/**
	 * Función que devuelve los puntos de cad jugador
	 * @param ronda Recibe el jugador que está jugando la ronda
	 * @return Devuelve los puntos del jugador correspondiente
	 */
	public static double puntosJugador(int ronda) {
		double puntos;
		
		 if(ronda==1) {
			 puntos = jug1;
		 }
		 else {
			 puntos = jug2;
		 }
		 return puntos;
	}

	/**
	 * Función que escribe la carta
	 * 
	 * @param puntos Usa los puntos de la carta para determinar cuál es
	 * @return Devuelve la carta y su palo por escrito
	 */
	public static String carta(double puntos) {
		String valor = "";
		int nobleza = 0;

		if (puntos == 0.5) { // Si la puntuación es de 0.5, es una carta de la nobleza
			nobleza = (int) (Math.random() * 3); // Escogemos su valor aleatoriamente

			switch (nobleza) { // Asignamos en función del valor que salga
			case 0:
				valor = "la sota " + palo();
				break;
			case 1:
				valor = "el caballo " + palo();
				break;
			case 2:
				valor = "el rey " + palo();
			}
		}

		else { // Si no es de la nobleza, le asignamos el valor que corresponde con los puntos
			switch ((int) puntos) {
			case 1:
				valor = "el as " + palo();
				break;
			case 2:
				valor = "el dos " + palo();
				break;
			case 3:
				valor = "el tres " + palo();
				break;
			case 4:
				valor = "el cuatro " + palo();
				break;
			case 5:
				valor = "el cinco " + palo();
				break;
			case 6:
				valor = "el seis " + palo();
				break;
			case 7:
				valor = "el siete " + palo();
				break;
			}
		}

		return valor;
	}

	/**
	 * Esta función escoge aleatoriamente un palo para asignarlo a la carta
	 * 
	 * @return Devuelve el palo de la carta en forma de cadena
	 */
	public static String palo() {
		String palo = "";
		int opcion = 0;

		opcion = (int) (Math.random() * 4);

		switch (opcion) {
		case 0:
			palo = "de oros.";
			break;
		case 1:
			palo = "de bastos.";
			break;
		case 2:
			palo = "de copas.";
			break;
		case 3:
			palo = "de espadas.";
		}
		return palo;
	}

	/**
	 * Esta función comprueba si los jugadores se han pasado del límite de puntos
	 * 
	 * @param punt Recibe los puntos del jugador por parámetro
	 * @return Devuelve un booleano en función de si se ha pasado o no
	 */
	public static Boolean pasao(double punt) {
		Boolean pasao = false;

		if (punt > maximoPuntos) {
			pasao = true;
		}

		return pasao;
	}

	/**
	 * Función que agrega la carta que se ha usado a un 'montón' aparte con el resto
	 * de usadas
	 * 
	 * @param carta        Recibe la carta que se ha sacado
	 * @param cartasUsadas Recibe el montón de cartas ya usadas
	 * @return Devuelve el montón actualizado
	 */
	public static String[] gastaCarta(String carta, String[] cartasUsadas) {

		cartasUsadas = Arrays.copyOf(cartasUsadas, cartasUsadas.length + 1);

		cartasUsadas[cartasUsadas.length - 1] = carta;

		return cartasUsadas;
	}

	/**
	 * Función que comprueba si la carta que se ha sacado está repetida o no
	 * 
	 * @param carta        Recibe la candidata a carta a salir
	 * @param cartasUsadas Recibe el montón de cartas ya usadas
	 * @return Devuelve un booleano en función de si está repetida o no
	 */
	public static Boolean cartaRepe(String carta, String[] cartasUsadas) {
		Boolean repetida = false;

		for (int i = 0; i < cartasUsadas.length; i++) {
			if (carta.equals(cartasUsadas[i])) {
				repetida = true;
				break;
			}
		}

		return repetida;
	}

	/**
	 * Función que devuelve el resultado de la partida, así como el ganador de la
	 * misma
	 * 
	 * @param punt1 Puntos del jugador 1
	 * @param punt2 Puntos del jugador 2
	 */
	public static void ganador(double punt1, double punt2) {

		if (punt1 > maximoPuntos && punt2 <= maximoPuntos) {
			System.out.print("El JUGADOR 1 TIENE " + punt1 + " puntos y el JUGADOR 2 tiene " + punt2
					+ " puntos.\n ¡El ganador es el JUGADOR 2!");
		} else if (punt1 <= maximoPuntos && punt2 > maximoPuntos) {
			System.out.print("El JUGADOR 1 TIENE " + punt1 + " puntos y el JUGADOR 2 tiene " + punt2
					+ " puntos.\n ¡El ganador es el JUGADOR 1!");
		} else if (punt1 <= maximoPuntos && punt2 <= maximoPuntos) {
			if (punt1 > punt2) {
				System.out.print("El JUGADOR 1 TIENE " + punt1 + " puntos y el JUGADOR 2 tiene " + punt2
						+ " puntos.\n ¡El ganador es el JUGADOR 1!");
			} else if (punt1 < punt2) {
				System.out.print("El JUGADOR 1 TIENE " + punt1 + " puntos y el JUGADOR 2 tiene " + punt2
						+ " puntos.\n ¡El ganador es el JUGADOR 2!");
			} else {
				System.out.print("El JUGADOR 1 TIENE " + punt1 + " puntos y el JUGADOR 2 tiene " + punt2
						+ " puntos.\n ¡Es un empate!");
			}
		} else {
			System.out.print("El JUGADOR 1 TIENE " + punt1 + " puntos y el JUGADOR 2 tiene " + punt2
					+ " puntos.\n Ambos jugadores se han pasado de 7.5: ¡es un empate!");
		}
	}

}