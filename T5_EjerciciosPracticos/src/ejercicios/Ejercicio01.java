package ejercicios;

import java.util.Arrays;

public class Ejercicio01 {
	static final int TAMANIO = 20;
	static final int MINAS = 6;
	public static void main(String[] args) {
		
		char tablero[] = new char [TAMANIO];
		
		tablero = rellenaMinas(tablero);
		
		System.out.println(Arrays.toString(tablero));
	}
	
	public static char[] rellenaMinas(char tablero[]) {
		int indice;
		char tableroMinas[] = new char [TAMANIO];
		
		for(int i=0; i<TAMANIO; i++) {
			tableroMinas[i] = '0';
		}
		
		for(int i=0; i<=MINAS; i++) {
			do {
				indice = (int)(Math.random()*(20+1)-1);
				tableroMinas[indice] = '*';
				
				if(bordeIzq(indice)) {
					tableroMinas[indice+1] += 1;
				}
				else if (bordeDer(indice)) {
					tableroMinas[indice-1] += 1;
				}
				else {
					tableroMinas[indice + 1] += 1;
					tableroMinas[indice - 1] += 1;
				}
			}while(tableroMinas[indice]!= '*');
		}
		return tableroMinas;
	}
	
	public static Boolean bordeIzq(int indice) {
		Boolean borde = false;
		
		if(indice == 0){
			borde=true;
		}
		
		return borde;
	}
	
	public static Boolean bordeDer(int indice) {
		Boolean borde = false;
		
		if(indice == (TAMANIO - 1)) {
			borde = true;
		}
		return borde;
	}
}
