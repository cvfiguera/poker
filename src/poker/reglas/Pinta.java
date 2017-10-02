package poker.reglas;

import java.util.Arrays;
import java.util.List;

public enum Pinta {
	
	DIAMANTE(0), TREBOL(2), CORAZON(2), PICA(3);
	static public List<Character> pintas = Arrays.asList("♦".charAt(0), 
											"♣".charAt(0), 
											"♥".charAt(0), 
											"♠".charAt(0));
	int orden = 0;
	
	Pinta(int orden) {
		this.orden = orden;
	}
	
	public int orden() {
		return orden;
	}
	
	public Character pinta() {
		return pintas.get(orden);
	}
	
	static public Character pinta(int orden) {
		return pintas.get(orden);
	}
}
