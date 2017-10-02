package poker.reglas;

import java.util.Arrays;
import java.util.List;

public enum Jerarquia {
	
	CARTA_ALTA(0), PAR(1), DOS_PARES(2), TRIO(3), ESCALERA(4), COLOR(5), 
	CASA_LLENA(6), POKER(7), ESCALERA_COLOR(8), ESCALERA_REAL(9);
	
	List<String> jerarquias = Arrays.asList("Carta Alta", "Par", "Dos Pares", "Trío", "Escalera",
			"Color", "Casa Llena", "Poker", "Escalera de Color", "Escalera Real");
	int orden = 0;
	
	Jerarquia(int orden) {
		this.orden = orden;		
	}
	
	public int orden() {
		return orden;
	}
	
	public String jerarquia() {
		return jerarquias.get(orden);
	}
	
}
