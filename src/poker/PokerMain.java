package poker;

import java.util.Scanner;

import poker.partida.ManoPoker;

public class PokerMain {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ManoPoker mano = new ManoPoker();
		System.out.println("Juego de Poker");
		System.out.print("\nIntroduzca el número de jugadores para la partida (Máximo " + mano.MAX_JUGADORES + "):");
		
		int n = in.nextInt();
		while (n > mano.MAX_JUGADORES) {
			System.out.println("El número de jugadores debe ser máximo : " + mano.MAX_JUGADORES);
			System.out.print("\nIntroduzca el número de jugadores para la partida: ");
			n = in.nextInt();
		}
        for(int i = 0; i < n; i++){
        	System.out.println("\nNombre de Jugador: ");
        	String str = in.next();
        	mano.entradaJugador(str);
        }
        mano.iniciarPartida();
       
        for(int i = 0; i < n; i++) {
        	System.out.print("\nCartas de " + mano.getJugadores().get(i).getNombre() + ": ");
        	mano.getJugadores().get(i).mostrarCartas().forEach(carta -> System.out.print(carta.toString() + " "));
        }
        
        mano.mostrarResutados();
    }
}
