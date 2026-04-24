package it.uniroma3.diadia;

public class IOSimulator implements IO {

    private String[] righeDaLeggere; // I comandi finti che inseriamo noi
    private int indiceLettura;

    private String[] messaggiStampati; // Il registro di quello che dice il gioco
    private int indiceScrittura;

    public IOSimulator(String[] righeDaLeggere) {
        this.righeDaLeggere = righeDaLeggere;
        this.indiceLettura = 0;
        
        // Creiamo un registro di 100 posizioni. Basteranno per qualsiasi test.
        this.messaggiStampati = new String[100]; 
        this.indiceScrittura = 0;
    }

    @Override
    public String leggiRiga() {
        // 1. Se abbiamo ancora comandi nell'array, peschiamo il prossimo
        if (this.indiceLettura < this.righeDaLeggere.length) {
            String comando = this.righeDaLeggere[this.indiceLettura];
            this.indiceLettura++;
            
            System.out.println("[SIMULATORE DIGITA] -> " + comando); // DEBUG
            return comando;
        }
        
        // 2. Se i comandi sono finiti, FORZIAMO la parola "fine".
        // Questo evita che il gioco vada in loop infinito o in crash!
        System.out.println("[SIMULATORE DIGITA] -> fine (comando di emergenza)"); // DEBUG
        return "fine"; 
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        System.out.println("[GIOCO RISPONDE]  -> " + messaggio); // DEBUG
        
        // Salviamo il messaggio nel nostro array-registro, se c'è ancora spazio
        if (this.indiceScrittura < this.messaggiStampati.length) {
            this.messaggiStampati[this.indiceScrittura] = messaggio;
            this.indiceScrittura++;
        }
    }

    /**
     * Metodo comodissimo per JUnit: controlla se in tutto il registro
     * c'è una riga che contiene la parola che stiamo cercando.
     */
    public boolean haStampato(String parolaDaCercare) {
        // Trasformiamo tutto in minuscolo per non avere problemi con le maiuscole
        String daCercare = parolaDaCercare.toLowerCase();

        for (int i = 0; i < this.indiceScrittura; i++) {
            if (this.messaggiStampati[i] != null) {
                String messaggioSalvato = this.messaggiStampati[i].toLowerCase();
                
                // Usiamo contains() che è molto più flessibile di equals()
                if (messaggioSalvato.contains(daCercare)) {
                    return true; // Trovato!
                }
            }
        }
        return false; // Non trovato in nessuna riga
    }
}