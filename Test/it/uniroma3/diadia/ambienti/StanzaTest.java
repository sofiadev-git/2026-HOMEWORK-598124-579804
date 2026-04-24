package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	private Stanza stanzaVuota;
	private Stanza stanzaConAttrezzo;
	private Attrezzo lanterna;

	@BeforeEach
	public void setUp() {
		this.stanzaVuota = new Stanza("Stanza Vuota");
		this.stanzaConAttrezzo = new Stanza("Stanza con Attrezzo");
		this.lanterna = new Attrezzo("lanterna", 3); 
		
		this.stanzaConAttrezzo.addAttrezzo(lanterna);
	}

	@Test
	public void testAddAttrezzo() {
		Attrezzo osso = new Attrezzo("osso", 1);
		boolean aggiunto = this.stanzaVuota.addAttrezzo(osso);
		
		assertTrue(aggiunto);
		assertEquals( osso, this.stanzaVuota.getAttrezzo("osso"));
	}

	@Test
	public void testGetStanzaAdiacente() {
		Stanza nord = new Stanza("Stanza a Nord");
		this.stanzaVuota.impostaStanzaAdiacente("nord", nord);
		
		assertEquals( nord, this.stanzaVuota.getStanzaAdiacente("nord"));
	}

	@Test
	public void testRemoveAttrezzo() {
		boolean rimosso = this.stanzaConAttrezzo.removeAttrezzo(lanterna);
		
		assertTrue( rimosso);
		assertNull( this.stanzaConAttrezzo.getAttrezzo("lanterna"));
	}

}
