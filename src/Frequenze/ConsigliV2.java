package Frequenze;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsigliV2 {

    public HashMap<String, Set<String>> utenti;
    public Set<String> acquisti;

    public ConsigliV2(){
        utenti = new HashMap<>();
        acquisti = new HashSet<>();
    }

    public Set<String> suggerisciProdotti(String utente) {
        Set<String> suggerimenti = new HashSet<>();

        // Recuperiamo gli acquisti dell'utente target
        Set<String> acquistiUtente = utenti.get(utente);

        // Controlliamo se l'utente esiste nella mappa
        if (acquistiUtente == null) {
            System.out.println("Utente non trovato.");
            return suggerimenti;
        }

        // Iteriamo su tutti gli altri utenti per trovare utenti simili
        for (String altroUtente : utenti.keySet()) {
            if (!altroUtente.equals(utente)) {  // Evitiamo di confrontare l'utente con se stesso
                Set<String> acquistiAltroUtente = utenti.get(altroUtente);

                // Troviamo i prodotti acquistati dall'altro utente ma non ancora acquistati dall'utente target
                for (String prodotto : acquistiAltroUtente) {
                    if (!acquistiUtente.contains(prodotto)) { // Suggeriamo solo prodotti non già acquistati
                        suggerimenti.add(prodotto);
                    }
                }
            }
        }
        return suggerimenti;
    }
}
