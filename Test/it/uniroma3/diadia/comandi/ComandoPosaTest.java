package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class ComandoPosaTest {
	
	private Partita partita;
	private ComandoPosa comando;
	
	@BeforeEach
	void setUp() throws Exception {
		IO io = new IOConsole();
		this.partita= new Partita(io);
		this.comando = new ComandoPosa();
	}

	@Test
	void testPosa() {
		Attrezzo attrezzo = new Attrezzo("asse",1);
		Borsa borsa= partita.getGiocatore().getBorsa();
		borsa.addAttrezzo(attrezzo);
		comando.setParametro("asse");
		comando.esegui(partita);
		assertFalse(borsa.hasAttrezzo("asse"));
		assertNotNull(partita.getStanzaCorrente().getAttrezzo("asse"));
	}

}
