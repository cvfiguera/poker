package poker.reglas;

import java.util.Arrays;
import java.util.List;

public enum Numero {
	
	AS(0), DOS(1), TRES(2), CUATRO(3), CINCO(4), SEIS(5), SIETE(6), OCHO(7), NUEVE(8),
	DIEZ(9), JACK(10), REINA(11), REY(12);
	
	static public List<String> numeros = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "J", "Q", "K");
	int orden = 0;
	
	Numero(int orden) {
		this.orden = orden;
	}
	
	public int orden() {
		return orden;
	}
	
	public String numero() {
		return numeros.get(orden);
	}
	
	static public String numero(int orden) {
		return numeros.get(orden);
	}
}
