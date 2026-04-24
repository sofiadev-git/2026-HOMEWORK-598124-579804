package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo attr = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		partita.getStanzaCorrente().addAttrezzo(attr); 

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}

}
