package poker.resultados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import poker.juego.Jugador;
import poker.reglas.Numero;
import poker.reglas.Premio;

public class EvaluadorMano {
	
	private List<Jugador> jugadores;
	private List<ResultadoVO> resultados;
	
	
	public EvaluadorMano(List<Jugador> jugadores) {
		super();
		this.jugadores = jugadores;
		this.resultados = new ArrayList<ResultadoVO>();
	}

	public List<ResultadoVO> entregarResultados() {
		evaluarManoPoker();
		return resultados;
	}
	
	private void evaluarManoPoker() {
		
		for(Jugador jugador: jugadores) {
			resultados.add(new ResultadoVO(jugador.getNombre(),
					jugador.determinarPoker(), jugador.mostrarCartas()));
		}
		asignarPremios();
	}
	
	private void ordenarJugadas() {
		Collections.sort(resultados, new Comparator<ResultadoVO>() {
			@Override
			public int compare(ResultadoVO r1, ResultadoVO r2) {
				if ((r1.getJugada().orden() - r2.getJugada().orden()) == 0) {
					if (r1.equals(desempatarJugada(r1, r2))) return -1;
					else return 1;
				}
				return r2.getJugada().orden() - r1.getJugada().orden();
			}
		});
	}
	
	private void asignarPremios() {
		ordenarJugadas();
		
		for(int i=0; i<resultados.size(); i++) {
			resultados.get(i).setPremio(Premio.premio(i));
		}
	}
	
	private ResultadoVO desempatarJugada(ResultadoVO r1, ResultadoVO r2) {
		
		switch (r1.getJugada()) {
		case ESCALERA_REAL: 
			return desempatarColor(r1, r2);
		case ESCALERA_COLOR:
			if(r1.getCartas().get(4) == r2.getCartas().get(4)) 
				return desempatarColor(r1,r2);				
			return (r1.getCartas().get(4).getNumero() > r2.getCartas().get(4).getNumero())?r1:r2;
		case POKER:
			return (r1.getCartas().get(2).getNumero()>r2.getCartas().get(2).getNumero())?r1:r2;
		case CASA_LLENA:
			return (r1.getCartas().get(2).getNumero() > r2.getCartas().get(2).getNumero())?r1:r2;
		case COLOR: 
			if (r1.getCartas().get(0).getPinta() == r2.getCartas().get(0).getPinta()) 
				return (r1.getCartas().get(4).getNumero() > r2.getCartas().get(4).getNumero())?r1:r2;
			return desempatarColor(r1, r2);
		case ESCALERA:
			if (r1.getCartas().get(4).getNumero() == r2.getCartas().get(4).getNumero()){
				if (r1.getCartas().get(4).getNumero() == Numero.REY.orden()) {
					if (r1.getCartas().get(0).getNumero() == Numero.AS.orden()) return r1;
					if (r2.getCartas().get(0).getNumero() == Numero.AS.orden()) return r2;
					return desempatarMano(r1, r2);
				}
			}
			return (r1.getCartas().get(4).getNumero() > r2.getCartas().get(4).getNumero())?r1:r2;
		case TRIO:
			return (r1.getCartas().get(2).getNumero() > r2.getCartas().get(2).getNumero())?r1:r2;
		case DOS_PARES:
			int r1p1=0, r1p2=0;
			int r2p1=0, r2p2=0;
			if (r1.getCartas().get(4).getNumero() == r1.getCartas().get(3).getNumero()) {
				r1p1 = r1.getCartas().get(4).getNumero();
			} else r1p1 = r1.getCartas().get(3).getNumero();
			if (r2.getCartas().get(4).getNumero() == r2.getCartas().get(3).getNumero()) {
				r2p1 = r2.getCartas().get(4).getNumero();
			} else r2p1 = r2.getCartas().get(3).getNumero();
			if (r1p1 == r2p1) {
				if(r1.getCartas().get(0).getNumero() == r1.getCartas().get(1).getNumero())
					r1p2 = r1.getCartas().get(0).getNumero();
				else r1p2 = r1.getCartas().get(1).getNumero();
				if(r2.getCartas().get(0).getNumero() == r2.getCartas().get(1).getNumero())
					r2p2 = r2.getCartas().get(0).getNumero();
				else r2p2 = r2.getCartas().get(1).getNumero();
				if (r1p2 == r2p2) {
					return desempatarCartaAlta(r1,r2);
				} else return (r1p2>r2p2)?r1:r2;
			} else return (r1p1>r2p1)?r1:r2;
		case PAR:
			int c1 = -1, c2 = -1;
			for (int i=0; c1>-1 && c2>-1; i++) {
				if (r1.getCartas().get(i).getNumero() == r1.getCartas().get(i+1).getNumero()) {
					c1 = r1.getCartas().get(i).getNumero();
				}
				if (r2.getCartas().get(i).getNumero() == r2.getCartas().get(i+1).getNumero()) {
					c2 = r2.getCartas().get(i).getNumero();
				}
			}
			if (c1 == c2) return desempatarCartaAlta(r1,r2);
			return (c1>c2)?r1:r2;
			
		case CARTA_ALTA: return desempatarCartaAlta(r1,r2);
		default: return desempatarMano(r1, r2);
		}
	}
	
	private ResultadoVO desempatarColor(ResultadoVO r1, ResultadoVO r2) {
		return (r1.getCartas().get(0).getPinta() > r2.getCartas().get(0).getPinta()) ? r1:r2;
	}
	
	private ResultadoVO desempatarCartaAlta(ResultadoVO r1, ResultadoVO r2) {
		if ((r1.getCartas().get(0).getNumero() == 0) && 
				(r2.getCartas().get(0).getNumero() != 0)) {
				return r1;
		} else if ((r1.getCartas().get(0).getNumero() != 0) && 
				(r2.getCartas().get(0).getNumero() == 0)) {
				return r2;
		}
		
		for (int i=4; i > 0; i--) {
			if(r1.getCartas().get(i).getNumero() != r2.getCartas().get(i).getNumero()) {
				return (r1.getCartas().get(i).getNumero() > r2.getCartas().get(i).getNumero())?r1:r2;
			}
		}
		return desempatarMano(r1, r2);
	}
	
	private ResultadoVO desempatarMano(ResultadoVO r1, ResultadoVO r2) {
		for(Jugador j: jugadores) {
			if (r1.getJugador().equals(j.getNombre())) return r1;
			if (r2.getJugador().equals(j.getNombre())) return r2;
		}
		return r1;
	}
}
