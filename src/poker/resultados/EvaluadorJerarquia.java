package poker.resultados;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import poker.juego.Carta;
import poker.reglas.Jerarquia;
import poker.reglas.Numero;

public class EvaluadorJerarquia {
	protected List<Carta> cartas;
	
	public EvaluadorJerarquia(List<Carta> cartas) {
		super();
		this.cartas = cartas;
	}
	
	protected Jerarquia determinarPoker() {
		
		ordenarCartas();
		
		if (esEscalera()) {
			if (esColor()) {
				if(cartas.get(0).getNumero() == Numero.AS.orden()
						&& cartas.get(1).getNumero() == Numero.DIEZ.orden()) {
					return Jerarquia.ESCALERA_REAL;
				} else return Jerarquia.ESCALERA_COLOR;
			} else return Jerarquia.ESCALERA;
		} else if (esColor()) return Jerarquia.COLOR;
		else {
			int distinct[] = cartas.stream()
					.mapToInt(carta -> carta.getNumero())
					.distinct().toArray();
			int nDistinct = distinct.length;
			
			if (nDistinct == 2) {
				 int n = (int) cartas.stream().filter(carta -> carta.getNumero() == distinct[0]).count();
				 if (n == 1 || n == 4) return Jerarquia.POKER;
				 if (n == 2 || n == 3) return Jerarquia.CASA_LLENA;
			} else if (nDistinct == 3) {
				 int n = (int) cartas.stream().filter(carta -> carta.getNumero() == distinct[0]).count();
				 if (n == 1) {
					 n = (int) cartas.stream().filter(carta -> carta.getNumero() == distinct[1]).count();
					 if (n == 1) return Jerarquia.TRIO;
				 }
				 if (n == 3) return Jerarquia.TRIO;
				 else if (n == 2) return Jerarquia.DOS_PARES;
			 } else if (nDistinct == 4) return Jerarquia.PAR;
		}
		return Jerarquia.CARTA_ALTA;
	}
	
	
	private boolean esColor() {
		return cartas.stream().map(carta -> carta.getPinta()).distinct().count() == 1;
	}
	
	private boolean esEscalera() {
		int i = 0;
		if (cartas.get(i).getNumero() == Numero.AS.orden()) {
			if (cartas.get(i+1).getNumero() != Numero.DOS.orden()) {
				if (cartas.get(cartas.size()-1).getNumero() == Numero.REY.orden())
					i = 1;
				else return false;
			}
		}
		int valor = cartas.get(i).getNumero() + 1;
		i++;
		for(; i<cartas.size(); i++) {
			if(cartas.get(i).getNumero() != valor) return false;
			valor = cartas.get(i).getNumero() + 1;
		}
		return true;
	}
	
	protected void ordenarCartas() {
		Collections.sort(cartas, new Comparator<Carta>() {
			@Override
			public int compare(Carta c1, Carta c2) {
				return c1.getNumero() - c2.getNumero();
			}
		});
	}
}
