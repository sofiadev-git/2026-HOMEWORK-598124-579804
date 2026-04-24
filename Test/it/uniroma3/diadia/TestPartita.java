package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPartita {

	private Partita partita;

	@BeforeEach
	void setUp() throws Exception {
		IO io = new IOConsole();
		this.partita= new Partita(io); //crea una nuova partita per evitare problemi
	}

	@Test
	void test_isFinita() {  //testiamo che il metodo faccia si che si concluda correttamente 
		this.partita.getGiocatore().setCfu(0);  // dovrebbe finire se cfu=0
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	void test_vittoria() {  //test per il metodo Vinta
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		
	}
	
	@Test
	void test_CfuIniziali() {
		assertEquals(20,this.partita.getGiocatore().getCfu());
	}
}
