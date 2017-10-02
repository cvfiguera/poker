package poker.juego;

public class Dealer extends Jugador {
	
	private BarajaInglesa baraja;
	
	public Dealer(String nombre, BarajaInglesa baraja) {
		super(nombre);
		this.baraja = baraja;
	}
	
	public void barajar() {
		baraja.barajar();
	}
	
	public Carta repartir() {
		return this.baraja.sacarUltima();
	}
}
