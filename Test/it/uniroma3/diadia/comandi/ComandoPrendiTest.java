package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class ComandoPrendiTest {

	private Partita partita;
	private ComandoPrendi comando;
	
	@BeforeEach
	void setUp() throws Exception {
		IO io = new IOConsole();
		this.partita= new Partita(io);
		this.comando = new ComandoPrendi();
	}

	@Test
	void testPrendi() {
		Attrezzo attrezzo = new Attrezzo("asse",1);
		Stanza stanza= partita.getStanzaCorrente();
		stanza.addAttrezzo(attrezzo);
		Borsa borsa= partita.getGiocatore().getBorsa();
		comando.setParametro("asse");
		comando.esegui(partita);
		assertTrue(borsa.hasAttrezzo("asse"));
		System.out.println("Attrezzi rimasti in stanza: " + stanza.getDescrizione());
	}

}
