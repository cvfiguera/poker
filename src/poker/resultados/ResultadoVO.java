package poker.resultados;

import java.util.List;

import poker.juego.Carta;
import poker.reglas.Jerarquia;

public class ResultadoVO {
	
	private String jugador;
	private Jerarquia jugada;
	private List<Carta> cartas;
	private String premio;
	
	public ResultadoVO(String jugador, Jerarquia jugada, List<Carta> cartas) {
		super();
		this.jugador = jugador;
		this.jugada = jugada;

		this.cartas = cartas;
	}

	public String getJugador() {
		return jugador;
	}

	public Jerarquia getJugada() {
		return jugada;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public String getPremio() {
		return premio;
	}

	public void setPremio(String premio) {
		this.premio = premio;
	}
}
