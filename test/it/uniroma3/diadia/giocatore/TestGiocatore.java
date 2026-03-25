package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

class TestGiocatore {

	private Giocatore giocatore;

	@BeforeEach
	void setUp() throws Exception {
		this.giocatore = new Giocatore();
	}
	
    @Test
    public void testCostruttore_CFUIniziali() {
        assertEquals(20, giocatore.getCfu());
    }

	@Test
	void test() {
		giocatore.setCfu(16);
		assertEquals(16, giocatore.getCfu());
	}

	@Test
	public void testBorsaNonNulla() {
		assertNotNull(giocatore.getBorsa());
	}

}
