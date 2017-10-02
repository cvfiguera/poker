package poker.juego;

import java.util.Collections;
import java.util.LinkedList;
import poker.reglas.Numero;
import poker.reglas.Pinta;

public class BarajaInglesa {

	public static final Integer N_CARTAS = 52;
	protected LinkedList<Carta> mazo;

	public BarajaInglesa() {
		mazo = new LinkedList<Carta>();
		for (int i = 0; i < Pinta.pintas.size(); i++) {
			for (int j = 0; j < Numero.numeros.size(); j++) {
				mazo.add(new Carta(j,i));
			}
		}
	}
	
	public void barajar() {
		Collections.shuffle(mazo);
	}
	
	public Carta sacarUltima() {
		if (mazo.size()>0)
			return mazo.removeLast();
		else return null;
	}
	
	public Carta sacarPrimera() {
		return mazo.removeFirst();
	}
}
