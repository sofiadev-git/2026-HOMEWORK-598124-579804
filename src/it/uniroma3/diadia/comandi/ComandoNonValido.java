package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("comando non valido");

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
