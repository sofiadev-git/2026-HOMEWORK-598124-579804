package it.uniroma3.diadia.ambienti;

/*La «stanza bloccata»: una delle direzioni della
stanza non può essere seguita a meno che nella
stanza non sia presente un oggetto con un nome
particolare (ad esempio "passepartout")
La classe StanzaBloccata deve avere due
variabili di istanza di tipo String per
momorizzare:
– il nome della direzione bloccata
– il nome dell'attrezzo che consente di sbloccare la
direzione bloccata

• Il metodo getStanzaAdiacente(String dir)
va riscritto (override)
– se nella stanza non è presente l'attrezzo sbloccante, il
metodo ritorna un riferimento alla stanza corrente
– altrimenti ha l’usuale comportamento (ritorna la stanza
corrispondente all'uscita specificata)
*/

public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private String attrezzoNecessario;

	public StanzaBloccata(String nome) {
		super(nome);
		direzioneBloccata="nord";
		attrezzoNecessario="chiave";
	}
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(direzioneBloccata)) {
			if(hasAttrezzo(attrezzoNecessario)) {
				return super.getStanzaAdiacente(direzioneBloccata);
			}
			else {
				return this;
			}
		}
		return super.getStanzaAdiacente(direzione);
	}

}
