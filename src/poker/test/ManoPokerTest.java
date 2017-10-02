package poker.test;

import java.util.ArrayList;
import java.util.List;

import poker.juego.BarajaInglesa;
import poker.juego.Carta;
import poker.juego.Dealer;
import poker.juego.Jugador;
import poker.reglas.Numero;
import poker.reglas.Pinta;
import poker.resultados.EvaluadorMano;
import poker.resultados.ResultadoVO;

public class ManoPokerTest {
	public static final int CARTAS_MAX_POKER = 5;
	public static final int MAX_JUGADORES = 10;
	private List<Jugador> jugadores;
	private List<ResultadoVO> resultados;
	private BarajaInglesa baraja;
	private Dealer dealer;
	private EvaluadorMano evaluador;

	public ManoPokerTest() {
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
		jugadores.get(0).recibir(new Carta(Numero.DIEZ.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(0).recibir(new Carta(Numero.JACK.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(0).recibir(new Carta(Numero.REINA.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(0).recibir(new Carta(Numero.REY.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(0).recibir(new Carta(Numero.AS.orden(), Pinta.DIAMANTE.orden()));
		
		jugadores.get(1).recibir(new Carta(Numero.DIEZ.orden(), Pinta.PICA.orden()));
		jugadores.get(1).recibir(new Carta(Numero.JACK.orden(), Pinta.CORAZON.orden()));
		jugadores.get(1).recibir(new Carta(Numero.REINA.orden(), Pinta.PICA.orden()));
		jugadores.get(1).recibir(new Carta(Numero.REY.orden(), Pinta.CORAZON.orden()));
		jugadores.get(1).recibir(new Carta(Numero.AS.orden(), Pinta.TREBOL.orden()));
	
		jugadores.get(2).recibir(new Carta(Numero.DOS.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(2).recibir(new Carta(Numero.CINCO.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(2).recibir(new Carta(Numero.OCHO.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(2).recibir(new Carta(Numero.SIETE.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(2).recibir(new Carta(Numero.TRES.orden(), Pinta.DIAMANTE.orden()));
		
		jugadores.get(3).recibir(new Carta(Numero.DIEZ.orden(), Pinta.CORAZON.orden()));
		jugadores.get(3).recibir(new Carta(Numero.DIEZ.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(3).recibir(new Carta(Numero.DIEZ.orden(), Pinta.PICA.orden()));
		jugadores.get(3).recibir(new Carta(Numero.REY.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(3).recibir(new Carta(Numero.AS.orden(), Pinta.DIAMANTE.orden()));
		
		jugadores.get(4).recibir(new Carta(Numero.TRES.orden(), Pinta.CORAZON.orden()));
		jugadores.get(4).recibir(new Carta(Numero.TRES.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(4).recibir(new Carta(Numero.TRES.orden(), Pinta.PICA.orden()));
		jugadores.get(4).recibir(new Carta(Numero.TRES.orden(), Pinta.TREBOL.orden()));
		jugadores.get(4).recibir(new Carta(Numero.AS.orden(), Pinta.TREBOL.orden()));
	
		jugadores.get(5).recibir(new Carta(Numero.DOS.orden(), Pinta.CORAZON.orden()));
		jugadores.get(5).recibir(new Carta(Numero.DOS.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(5).recibir(new Carta(Numero.TRES.orden(), Pinta.PICA.orden()));
		jugadores.get(5).recibir(new Carta(Numero.REY.orden(), Pinta.TREBOL.orden()));
		jugadores.get(5).recibir(new Carta(Numero.AS.orden(), Pinta.TREBOL.orden()));
		
		jugadores.get(6).recibir(new Carta(Numero.TRES.orden(), Pinta.CORAZON.orden()));
		jugadores.get(6).recibir(new Carta(Numero.TRES.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(6).recibir(new Carta(Numero.TRES.orden(), Pinta.PICA.orden()));
		jugadores.get(6).recibir(new Carta(Numero.CUATRO.orden(), Pinta.TREBOL.orden()));
		jugadores.get(6).recibir(new Carta(Numero.CUATRO.orden(), Pinta.TREBOL.orden()));
	
		jugadores.get(7).recibir(new Carta(Numero.NUEVE.orden(), Pinta.CORAZON.orden()));
		jugadores.get(7).recibir(new Carta(Numero.NUEVE.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(7).recibir(new Carta(Numero.JACK.orden(), Pinta.PICA.orden()));
		jugadores.get(7).recibir(new Carta(Numero.JACK.orden(), Pinta.TREBOL.orden()));
		jugadores.get(7).recibir(new Carta(Numero.AS.orden(), Pinta.TREBOL.orden()));
		
		jugadores.get(8).recibir(new Carta(Numero.TRES.orden(), Pinta.CORAZON.orden()));
		jugadores.get(8).recibir(new Carta(Numero.DIEZ.orden(), Pinta.DIAMANTE.orden()));
		jugadores.get(8).recibir(new Carta(Numero.CINCO.orden(), Pinta.PICA.orden()));
		jugadores.get(8).recibir(new Carta(Numero.REY.orden(), Pinta.TREBOL.orden()));
		jugadores.get(8).recibir(new Carta(Numero.AS.orden(), Pinta.TREBOL.orden()));

		/* Desempate Mano
		jugadores.get(8).recibir(new Carta(Numero.DOS.orden(), Pinta.CORAZON.orden()));
		jugadores.get(8).recibir(new Carta(Numero.TRES.orden(), Pinta.CORAZON.orden()));
		jugadores.get(8).recibir(new Carta(Numero.CUATRO.orden(), Pinta.CORAZON.orden()));
		jugadores.get(8).recibir(new Carta(Numero.CINCO.orden(), Pinta.CORAZON.orden()));
		jugadores.get(8).recibir(new Carta(Numero.AS.orden(), Pinta.CORAZON.orden()));
		*/
		
		jugadores.get(9).recibir(new Carta(Numero.DOS.orden(), Pinta.CORAZON.orden()));
		jugadores.get(9).recibir(new Carta(Numero.TRES.orden(), Pinta.CORAZON.orden()));
		jugadores.get(9).recibir(new Carta(Numero.CUATRO.orden(), Pinta.CORAZON.orden()));
		jugadores.get(9).recibir(new Carta(Numero.CINCO.orden(), Pinta.CORAZON.orden()));
		jugadores.get(9).recibir(new Carta(Numero.AS.orden(), Pinta.CORAZON.orden()));
		
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
