package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {
	
	private Partita partita;
	private ComandoVai comandovai;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.comandovai = new ComandoVai();
		IO io = new IOConsole();
		this.partita= new Partita(io);
	}

	@Test
	void testVaiInBiblioteca() {
		
		Stanza biblioteca = new Stanza("Biblioteca");
		this.partita.getStanzaCorrente().impostaStanzaAdiacente("nord", biblioteca);
		comandovai.setParametro("nord");
		comandovai.esegui(partita);
		assertEquals(biblioteca,this.partita.getStanzaCorrente());
	}

}
