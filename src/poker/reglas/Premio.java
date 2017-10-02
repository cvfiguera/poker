package poker.reglas;

import java.util.Arrays;
import java.util.List;

public enum Premio {
	
	PRIMER(0), SEGUNDO(1), TERCERO(2), CUARTO(3), QUINTO(4),
	SEXTO(5), SEPTIMO(6), OCTAVO(7), NOVENO(9), DECIMO(9);
	static public List<String> premios = Arrays.asList("Ganador",
			"2do Lugar", "3er Lugar", "4to Lugar", "5to Lugar",
			"6to Lugar", "7mo Lugar", "8vo Lugar", "9no Lugar",
			"10mo Lugar");
	int orden = 0;
	
	Premio(int orden) {
		this.orden = orden;
	}
	
	public int orden() {
		return orden;
	}
	
	public String premio() {
		return premios.get(orden);
	}
	
	static public String premio(int orden) {
		return premios.get(orden);
	}
}
