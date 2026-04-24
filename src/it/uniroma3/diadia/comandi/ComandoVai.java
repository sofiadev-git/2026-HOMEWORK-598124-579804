package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	
	public String direzione;
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente= partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(this.direzione==null) {
			partita.getIO().mostraMessaggio("Specifica una direzione"); //MODIFICA
			return;
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		
		if(prossimaStanza==null) {
			partita.getIO().mostraMessaggio("direzione inesistente"); //MODIFICA
			return;
		} 
		partita.setStanzaCorrente(prossimaStanza); //aggiorno nella partita
		stanzaCorrente= partita.getStanzaCorrente(); //aggiorno la variabile locale
		partita.getIO().mostraMessaggio(stanzaCorrente.getNome()); 
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		int cfucorrenti= partita.getGiocatore().getCfu();
		partita.getIO().mostraMessaggio("cfu rimanenti = "+cfucorrenti);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
}
