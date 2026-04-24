package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
