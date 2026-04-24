package it.uniroma3.diadia;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DiaDiaTest {

    @Test
    public void testDirezioneInesistente() {
        // 1. Diamo al simulatore solo il comando che vogliamo testare
        String[] comandi = { "vai su" };
        IOSimulator simulatore = new IOSimulator(comandi);

        // 2. Facciamo partire il gioco
        DiaDia gioco = new DiaDia(simulatore);
        gioco.gioca();

        // 3. Verifichiamo se il gioco ha stampato l'errore (ignora le maiuscole grazie al toLowerCase)
        assertTrue(simulatore.haStampato("direzione inesistente")); 
    }
    
    @Test
    public void testVittoria() {
        // 1. Prepariamo la sequenza di comandi che porta alla vittoria
        String[] comandi = {
            "vai est",      // Entra nella stanza col tesoro/chiave
            "prendi chiave", // Raccoglie l'oggetto
            "vai ovest",     // Torna indietro
            "posa chiave",   // Lascia l'oggetto (magari serve per sbloccare qualcosa)
            "vai nord"       // Entra nella stanza vincente (es. Biblioteca)
        };
        
        // 2. Creiamo il simulatore con questi comandi
        IOSimulator ioSim = new IOSimulator(comandi);

        // 3. Avviamo il gioco passandogli il simulatore
        DiaDia gioco = new DiaDia(ioSim);
        gioco.gioca();

        // 4. Verifichiamo che tra i messaggi stampati ci sia quello di vittoria.
        // Il tuo DiaDia.java stampa "hai vinto!" se partita.vinta() è true.
        assertTrue("Il gioco doveva terminare con una vittoria!", 
                   ioSim.haStampato("hai vinto!"));
    }
    
}