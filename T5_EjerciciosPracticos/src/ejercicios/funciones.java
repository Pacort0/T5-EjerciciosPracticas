package ejercicios;

public class funciones {

	static final int TAMANIO = 20;
	static final int MINAS = 6;

	public static char[] rellenaMinas(char tablero[]) {
		int indice;
		char tableroMinas[] = new char[TAMANIO];
		char contador = 0;

		for (int i = 0; i < TAMANIO; i++) {
			tableroMinas[i] = '0';
		}

		while (contador < MINAS) {

			indice = (int) (Math.random() * (20 + 1) - 1);
			if (tableroMinas[indice] == '*') {
				contador--;
			} else {
				tableroMinas[indice] = '*';

				if (bordeIzq(indice)) {
					if (!compruebaMinaDer(tableroMinas, indice)) {
						tableroMinas[indice + 1] += 1;
					}
				} else if (bordeDer(indice)) {
					if (!compruebaMinaIzq(tableroMinas, indice)) {
						tableroMinas[indice - 1] += 1;
					}
				} else {
					if (!compruebaMinaIzq(tableroMinas, indice)) {
						tableroMinas[indice - 1] += 1;
					}
					if (!compruebaMinaDer(tableroMinas, indice)) {
						tableroMinas[indice + 1] += 1;
					}
				}
			}
			contador++;
		}
		return tableroMinas;
	}

	public static Boolean bordeIzq(int indice) {
		Boolean borde = false;

		if (indice == 0) {
			borde = true;
		}

		return borde;
	}

	public static Boolean bordeDer(int indice) {
		Boolean borde = false;

		if (indice == (TAMANIO - 1)) {
			borde = true;
		}
		return borde;
	}

	public static Boolean compruebaMinaDer(char tablero[], int indice) {
		Boolean mina = false;

		if (tablero[indice + 1] == '*') {
			mina = true;
		}

		return mina;
	}

	public static Boolean compruebaMinaIzq(char tablero[], int indice) {
		Boolean mina = false;

		if (tablero[indice - 1] == '*') {
			mina = true;
		}

		return mina;
	}
}
