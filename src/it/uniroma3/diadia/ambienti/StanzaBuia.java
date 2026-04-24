package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IOConsole;

/*/*
 * – La «stanza buia»: se nella stanza non è presente un
attrezzo con un nome particolare (ad esempio
"lanterna") il metodo getDescrizione() di una
stanza buia ritorna la stringa "qui c'è un buio pesto"
 * La classe StanzaBuia deve avere una variabile di
istanza di tipo String: memorizza il nome
dell'attrezzo che consente di avere la descrizione
completa della stanza
• Il metodo getDescrizione() va sovrascritto
affinché produca la descrizione usuale o la stringa
"qui c'è buio pesto" a seconda che nella
stanza ci sia o meno l'attrezzo richiesto per
"vedere"
• Il nome dell'attrezzo necessario viene impostato
attraverso il costruttore*/

public class StanzaBuia extends Stanza {
	private String attrezzoNecessario;
	IOConsole io;
	public StanzaBuia(String nome) {
		super(nome);
		this.attrezzoNecessario = "lanterna";
	}
	
	@Override
	public String getDescrizione() {
		if(hasAttrezzo(this.attrezzoNecessario)) {
			return super.toString();
		}
		return "qui c'è buio pesto";
	}
}
