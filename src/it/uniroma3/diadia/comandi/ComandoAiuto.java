package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

	static final private String[] elencoComandi = { "vai <nord/sud/Est/ovest>", "aiuto", "fine", "prendi <attrezzo>", "posa <attrezzo>", "guarda"};
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		for (int i = 0; i < elencoComandi.length; i++)
			partita.getIO().mostraMessaggio(elencoComandi[i] + " ");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		//non serve un parametro
	}

}
