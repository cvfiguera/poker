package poker.test;

public class PokerMainTest {
	
	public static void main(String[] args) {
		ManoPokerTest mano = new ManoPokerTest();
		mano.entradaJugador("J1");
		mano.entradaJugador("J2");
		mano.entradaJugador("J3");
		mano.entradaJugador("J4");
		mano.entradaJugador("J5");
		mano.entradaJugador("J6");
		mano.entradaJugador("J7");
		mano.entradaJugador("J8");
		mano.entradaJugador("J9");
		mano.entradaJugador("J10");
		
        mano.iniciarPartida();
        
        mano.mostrarResutados();
    }

}
