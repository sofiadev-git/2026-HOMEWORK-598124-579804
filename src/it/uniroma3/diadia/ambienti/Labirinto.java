package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	/*ha la responsabilità di creare il labirinto, di memorizzare la stanza
	iniziale (entrata) e quella finale (uscita)
	
	– aggiungere un riferimento ad un'istanza di Labirinto nella classe
	Partita (che ovviamente dovrà essere liberata dalle
	responsabilità spostate nella nuova classe)*/

	private Stanza iniziale;
	private Stanza vincente;
	
	public Labirinto() {

				/* crea gli attrezzi */
		    	Attrezzo lanterna = new Attrezzo("lanterna",3);
				Attrezzo osso = new Attrezzo("osso",2);
				Attrezzo chiave = new Attrezzo("chiave",1);
		    	
				/* crea stanze del labirinto */
				StanzaBloccata atrio = new StanzaBloccata("Atrio");
				Stanza aulaN11 = new Stanza("Aula N11");
				Stanza aulaN10 = new Stanza("Aula N10");
				StanzaMagica labIA = new StanzaMagica("Laboratorio Campus",0);
				Stanza biblioteca = new Stanza("Biblioteca");
				StanzaBuia mensa = new StanzaBuia("mensa");
				
				
				/* collega le stanze */
				atrio.impostaStanzaAdiacente("nord", biblioteca);
				atrio.impostaStanzaAdiacente("est", aulaN11);
				atrio.impostaStanzaAdiacente("sud", aulaN10);
				atrio.impostaStanzaAdiacente("ovest", labIA);
				aulaN11.impostaStanzaAdiacente("nord", mensa);
				aulaN11.impostaStanzaAdiacente("est", labIA);
				aulaN11.impostaStanzaAdiacente("ovest", atrio);
				mensa.impostaStanzaAdiacente("sud", aulaN11);
				aulaN10.impostaStanzaAdiacente("nord", atrio);
				aulaN10.impostaStanzaAdiacente("est", aulaN11);
				aulaN10.impostaStanzaAdiacente("ovest", labIA);
				labIA.impostaStanzaAdiacente("est", atrio);
				labIA.impostaStanzaAdiacente("ovest", aulaN11);
				biblioteca.impostaStanzaAdiacente("sud", atrio);

		        /* pone gli attrezzi nelle stanze */
				atrio.addAttrezzo(lanterna);
				atrio.addAttrezzo(osso);
				//la chiave va messa nella stanza buia poi
				aulaN11.addAttrezzo(chiave);

				// il gioco comincia nell'atrio
		        iniziale = atrio;  
				vincente = biblioteca;
	}
	


	public Stanza getStanzaIniziale() {
		return this.iniziale;

	}

	public Stanza getStanzaVincente() {
		return this.vincente;
	}
}
