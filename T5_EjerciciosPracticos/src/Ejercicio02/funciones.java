package Ejercicio02;

public class funciones {

	public static void rellenaValores(double[]valores) {
		double cartas[] = valores;
		
		for (int i = 0; i < cartas.length; i++) {
			if (i == 7) {
				cartas[i] = 0.5;
			} else {
				cartas[i] = (i+1);
			}
		}
	}
	
	public static void nobleza() {
		
	}
}
