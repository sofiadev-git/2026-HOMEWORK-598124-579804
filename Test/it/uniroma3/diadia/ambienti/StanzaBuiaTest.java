package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	private Partita partita;

	@BeforeEach
	void setUp() throws Exception {
		IO io = new IOConsole();
		partita = new Partita(io);
	}

	@Test
	void testDescr() {
		String[] comandi = {
	            "vai est",         
	            "vai nord",     
	        };
	        
	        // 2. Creiamo il simulatore con questi comandi
	        IOSimulator ioSim = new IOSimulator(comandi);

	        // 3. Avviamo il gioco passandogli il simulatore
	        DiaDia gioco = new DiaDia(ioSim);
	        gioco.gioca();
		if (!partita.getStanzaCorrente().hasAttrezzo("lanterna")) {
			assertSame("qui c'è buio pesto", partita.getStanzaCorrente().getDescrizione());
		}
	}

}
