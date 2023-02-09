package Ejercicio02;

public class funciones {
	
	public static void rellenaValores(double[]valores) {
		double cartas[] = valores;
		
		for (int i = 0; i < cartas.length; i++) {
			if (i >= 7) {
				cartas[i] = 0.5;
			} else {
				cartas[i] = (i+1);
			}
		}
	}
	
	public static double puntos(double[] valores) {
		double puntos;
		
		puntos = (Math.random()*(10) - 1);
		puntos = valores [(int)puntos];
		
		return puntos;
	}
	
	public static String carta( double puntos) {
		String valor = "";
		int miembro = 0;
		
		if(puntos == 0.5 ) {
			miembro = (int)(Math.random()*3);
			
			switch(miembro) {
			case 0: valor = " la sota " + palo();
			break;
			case 1: valor = " el caballo " + palo();
			break;
			case 2: valor = " el rey " + palo();
			}
		}
		
		else {
			switch((int)puntos) {
			case 1: valor = "as " + palo();
			break;
			case 2: valor = "dos " + palo();
			break;
			case 3: valor = "tres " + palo();
			break;
			case 4: valor = "cuatro " + palo();
			break;
			case 5: valor = "cinco " + palo();
			break;
			case 6: valor = "seis " + palo();
			break;
			case 7: valor = "siete " + palo();
			break;
			}
		}
		
		return valor;
	}
	
	public static String palo() {
		String palo = "";
		int opcion = 0;
		
		opcion = (int)(Math.random()*4);
		
		switch(opcion) {
		case 0: palo = " de oros.";
		break;
		case 1: palo = " de bastos.";
		break;
		case 2: palo = " de copas.";
		break;
		case 3: palo = " de espadas.";
		}
		return palo;
	}
	
	public static Boolean pasao(double punt) {
		Boolean pasao = false;
		
		if(punt > 7.5) {
			pasao = true;
		}
		
		return pasao;
 	}
	
	public static void ganador(double punt1, double punt2) {
		
		if(punt1 > 7.5 && punt2 <= 7.5) {
			System.out.print("¡El ganador es el JUGADOR 2!");
		}
		else if (punt1 <= 7.5 && punt2 > 7.5) {
			System.out.print("¡El ganador es el JUGADOR 1!");
		}
		else if (punt1 <=7.5 && punt2 <= 7.5) {
			if(punt1 > punt2) {
				System.out.print("¡El ganador es el JUGADOR 1!");
			}
			else if (punt1 < punt2){
				System.out.print("¡El ganador es el JUGADOR 2!");
			}
			else {
				System.out.print ("¡Es un empate!");
			}
		}
		else {
			System.out.print("Ambos jugadores se han pasado de 7.5: ¡es un empate!");
		}
	}
	
}
