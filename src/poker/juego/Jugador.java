package poker.juego;

import java.util.ArrayList;
import java.util.List;

import poker.resultados.EvaluadorJerarquia;

public class Jugador extends EvaluadorJerarquia {
	
	static final int MAX_POKER = 5;
	private String nombre;
	
	
	public Jugador(String nombre) {
		super(new ArrayList<Carta>());
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void descartar(Carta carta) {	
		cartas.remove(carta);
	}
	
	public void recibir(Carta carta) {
		if (cartas.size() < MAX_POKER) {
			cartas.add(carta);
		}
	}

	public List<Carta> mostrarCartas() {
		return cartas;
	}
}
