package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
    private Labirinto labirinto;

    @Before
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
