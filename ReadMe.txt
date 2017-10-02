Poker.

Explicación:

- Ejecutar por la Clase poker.PokerMain.
- Se pide introducir un número de jugadores por consola.
- Se pide el ingreso del nombre o identificador de cada jugador.
- Se muestran las cartas repartidas en el orden en que se repartieron.
- Se muestran los resultados del análisis de la mano de cada jugador, en orden de
  Ganador a ultimo lugar.

- Nota1: se diseño una clase main de prueba poker.test.PokerMainTest para verificar todas las jerarquías

- Reglas de Desempate: Primero por Jerarquia de Jugada, Segundo por jeraría de número,
  Tercero por jerarquía de color, y por ultimo por Jugador Mano (más cerca del dealer)
  de izquierda a derecha).

- Nota2: el AS se toma como carta alta, pero se ordena al principio. Por ejemplo:

	Jugador: j2
	Premio: 4to Lugar
	Jugada: CARTA_ALTA
	Cartas: A♣ 2♣ 3♦ 7♣ J♠ 

	Jugador: j3
	Premio: 5to Lugar
	Jugada: CARTA_ALTA
	Cartas: A♥ 3♣ 4♦ 9♥ 10♣ 

Ambos tienen AS como carta alta, para desempate van a la siguiente carta alta.
