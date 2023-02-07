package ejercicios;

import java.util.Arrays;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		char tablero[] = new char [funciones.TAMANIO];
		
		tablero = funciones.rellenaMinas(tablero);
		
		System.out.println(Arrays.toString(tablero));
	}	
}