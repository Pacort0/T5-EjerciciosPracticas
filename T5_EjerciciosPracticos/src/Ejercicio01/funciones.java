package Ejercicio01;

/**
 * Clase funciones del ejercicio01
 * @author Francisco Rodríguez Tejada
 *
 */
public class funciones {

	static final int TAMANIO = 20; //Variable global para definir el tamaño del tablero
	static final int MINAS = 6; //Variable global para determinar la cantidad de minas
	
	/**
	 * Se muestra el valor de la casilla elegida
	 * @param tableroJuego es el tablero que ve el usuario
	 * @param tableroRelleno es el tablero con las bombas y las pistas
	 * @param casilla es el índice a destapar
	 * @return devuelve el array 'tableroJuego' con el valor de la posición 'casilla' alterado
	 */
	
	public static char[] juego(char tableroJuego[], char tableroRelleno[], int casilla) {
		
		if(tableroJuego[casilla] == '-') {
			tableroJuego[casilla] = tableroRelleno[casilla];
		}
		
		return tableroJuego;
	}
	
	/**
	 * Se comprueba si el jugador ha pisado una mina
	 * @param tableroRelleno tablero con las minas y las pistas
	 * @param casilla índice a destapar
	 * @return devuelve un booleano que dice si se ha perdido
	 */
	public static Boolean derrota(char tableroRelleno[], int casilla) {
		Boolean fin = false;
		
		if(tableroRelleno[casilla] == '*') {
			fin = true;
		}
		
		return fin;
	}
	
	/**
	 * Se comprueba si se han destapado todas las casillas sanas
	 * @param resultado recibe un contador de casillas destapadas
	 * @return devuelve un booleano que indica si se ha ganado
	 */
	public static Boolean victoria(int resultado) {
		Boolean fin = false;
		
		if(resultado > 13) {
			fin = true;
		}
		return fin;
	}
	
	/**
	 * Rellena el tablero de minas y pistas
	 * @param tablero recibe el tablero vacío
	 * @return devuelve un tablero diferente relleno
	 */
	public static char[] rellenaMinas(char tablero[]) {
		int indice; //Para guardar las minas en valores aleatorios
		char tableroMinas[] = new char[TAMANIO]; //Creamos un nuevo array 
		char contador = 0; //Contador para rellenar las minas necesarias

		for (int i = 0; i < TAMANIO; i++) { //Rellenamos el array inicialmente con ceros
			tableroMinas[i] = '0';
		}

		while (contador < MINAS) { //Bucle while que se cortará tras rellenar 6 minas

			indice = (int) (Math.random() * (20 + 1) - 1); //Guardamos el índice generado aleatoriamente
			if (tableroMinas[indice] == '*') { //Si en esa posición ya hay una mina, descontamos -1 al contador
				contador--;
			} else {
				tableroMinas[indice] = '*'; //Si no hay mina, la ponemos

				if (bordeIzq(indice)) { //Llamamos a la función bordeIzq
					if (!compruebaMinaDer(tableroMinas, indice)) { //Si no hay mina a la derecha, sumamos +1 al 'indice + 1'
						tableroMinas[indice + 1] += 1;
					}
				} else if (bordeDer(indice)) { //Llamamos a la función bordeDer
					if (!compruebaMinaIzq(tableroMinas, indice)) { //Si no hay mina a la izquierda, sumamos +1 a 'indice - 1'
						tableroMinas[indice - 1] += 1;
					}
				} else { 
					if (!compruebaMinaIzq(tableroMinas, indice)) { //Si no hay mina a la izquierda, sumammos +1 a 'indice - 1'
						tableroMinas[indice - 1] += 1;
					}
					if (!compruebaMinaDer(tableroMinas, indice)) { //Si no hay mina a la derecha, sumamos +1 a 'indice + 1'
						tableroMinas[indice + 1] += 1;
					}
				}
			}
			contador++; //Como hemos metido una mina con éxito, incrementamos el contador
		}
		return tableroMinas; //Devolvemos el tablero relleno
	}
	
	/**
	 * Método para comprobar si estamos en el borde de la izquierda
	 * @param indice recibe una posición por parámetros
	 * @return Devuelve un booleano que nos dice si estamos en el borde o no
	 */
	public static Boolean bordeIzq(int indice) {
		Boolean borde = false;

		if (indice == 0) {
			borde = true;
		}

		return borde;
	}
	
	/**
	 * Método para comprobar si estamos en el borde de la derecha
	 * @param indice recibe una posición por parámetros
	 * @return Devuelve un booleano que nos dice si estamos en el borde o no
	 */
	public static Boolean bordeDer(int indice) {
		Boolean borde = false;

		if (indice == (TAMANIO - 1)) {
			borde = true;
		}
		return borde;
	}
	
	/**
	 * Comprueba si hay una mina a la derecha de un índice dado
	 * @param tablero recibe el tablero que está siendo rellenado
	 * @param indice recibe una posición por parámetros
	 * @return Devuelve un booleano que nos confirma si existe una mina o no
	 */
	public static Boolean compruebaMinaDer(char tablero[], int indice) {
		Boolean mina = false;

		if (tablero[indice + 1] == '*') {
			mina = true;
		}

		return mina;
	}
	
	/**
	 * Comprueba si hay una mina a la derecha de un índice dado
	 * @param tablero recibe el tablero que está siendo rellenado
	 * @param indice recibe el tablero que está siendo rellenado
	 * @return Devuelve un booleano que nos confirma si existe una mina o no
	 */
	public static Boolean compruebaMinaIzq(char tablero[], int indice) {
		Boolean mina = false;

		if (tablero[indice - 1] == '*') {
			mina = true;
		}

		return mina;
	}
}
