package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestBorsa {

	private Borsa borsa;

	@BeforeEach
	void setUp() throws Exception {
		this.borsa = new Borsa();
	}

	@Test
	void testPesoMax() {
		assertEquals(10,borsa.getPesoMax());
	}
	
	@Test
	void AttrezzoBorsa(){
		Attrezzo a = new Attrezzo("clava",7);
		this.borsa.addAttrezzo(a);
		assertEquals(this.borsa.getAttrezzo("clava"), a);
	}

}
