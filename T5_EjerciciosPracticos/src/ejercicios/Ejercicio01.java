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
		
		for(int i=0; i<MINAS; i++) {
			do {
				indice = (int)(Math.random()*(20+1)-1);
				tableroMinas[indice] = '*';
				
				if(bordeIzq(indice)) {
					if(!compruebaMinaDer(tableroMinas, indice)) {
					tableroMinas[indice + 1] += 1;
					}
				}
				else if (bordeDer(indice)) {
					if(!compruebaMinaIzq(tableroMinas, indice)) {
					tableroMinas[indice + 1] += 1;
					}
				}
				else{
					if(!compruebaMinaIzq(tableroMinas, indice)) {
					tableroMinas[indice - 1] += 1;
					}
					if(!compruebaMinaDer(tableroMinas, indice)) {
						tableroMinas[indice + 1] += 1;
					}
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
	
	public static Boolean compruebaMinaDer(char tablero[], int indice) {
		Boolean mina = false;
		
		if(tablero[indice + 1]=='*') {
			mina = true;
		}
		
		return mina;
	}
	public static Boolean compruebaMinaIzq(char tablero[], int indice) {
		Boolean mina = false;
		
		if(tablero[indice - 1]=='*') {
			mina = true;
		}
		
		return mina;
	}
}
