package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo attr = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (attr == null) {
			partita.getIO().mostraMessaggio("L'Attrezzo " + this.nomeAttrezzo + " non presente nella stanza!");
	        return;
		}
		
		if(partita.getGiocatore().getBorsa().addAttrezzo(attr)) {
			partita.getIO().mostraMessaggio("hai preso " + attr);
			partita.getStanzaCorrente().removeAttrezzo(attr);
		}
		else {
			partita.getIO().mostraMessaggio("borsa piena");
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}

}
