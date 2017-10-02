package poker.partida;

import java.util.ArrayList;
import java.util.List;

import poker.juego.BarajaInglesa;
import poker.juego.Carta;
import poker.juego.Dealer;
import poker.juego.Jugador;
import poker.resultados.EvaluadorMano;
import poker.resultados.ResultadoVO;

public class ManoPoker {
	public static final int CARTAS_MAX_POKER = 5;
	public static final int MAX_JUGADORES = 10;
	private List<Jugador> jugadores;
	private List<ResultadoVO> resultados;
	private BarajaInglesa baraja;
	private Dealer dealer;
	private EvaluadorMano evaluador;

	public ManoPoker() {
		super();
		jugadores = new ArrayList<Jugador>();
		baraja = new BarajaInglesa();
	}

	public void entradaJugador(String nombre) {
		if (jugadores.size() == 0)
			dealer = new Dealer(nombre, this.baraja);
		jugadores.add(new Jugador(nombre));
	}
	
	public void iniciarPartida() {		
		dealer.barajar();
		for (int i = CARTAS_MAX_POKER - 1; i >= 0; i--) {
			jugadores.forEach(jugador -> jugador.recibir(dealer.repartir()));
		}
	}
	
	public void mostrarResutados() {
		evaluador = new EvaluadorMano(jugadores);
		resultados = evaluador.entregarResultados();
		System.out.print("\n\nResultados de la Mano");
		for (ResultadoVO resultado : resultados) {
			System.out.println("\n\nJugador: " + resultado.getJugador());
			System.out.println("Premio: " + resultado.getPremio());
			System.out.println("Jugada: " + resultado.getJugada().name());
			System.out.print("Cartas: ");
			resultado.getCartas().forEach(carta -> System.out.print(carta.toString() + " "));
		}
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public Dealer getDealer() {
		return dealer;
	}
}
