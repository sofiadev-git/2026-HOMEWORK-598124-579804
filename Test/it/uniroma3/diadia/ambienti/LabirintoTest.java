package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {

	private Labirinto labirinto;

	@BeforeEach
	public void setUp() {
		labirinto = new Labirinto();
	}

	@Test
	public void testStanzaCorrenteIniziale() {
		assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
	}

	@Test
	public void testStanzaVincente() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}

}
