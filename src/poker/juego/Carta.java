package poker.juego;

import poker.reglas.Numero;
import poker.reglas.Pinta;

public class Carta {
	
	private int numero;
	private int pinta;
	
	public Carta() {
		super();
	}

	public Carta(int numero, int pinta) {
		super();
		this.numero = numero;
		this.pinta = pinta;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPinta() {
		return pinta;
	}

	public void setPinta(int pinta) {
		this.pinta = pinta;
	}

	@Override
	public String toString() {
		return Numero.numero(numero) + "" + Pinta.pinta(pinta);
	}

}
