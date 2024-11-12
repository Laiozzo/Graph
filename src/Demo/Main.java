package Demo;

import Frequenze.ConsigliV2;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Creiamo un'istanza della classe Consigli
        ConsigliV2 consigli = new ConsigliV2();

        // Aggiungiamo utenti e i loro prodotti acquistati utilizzando HashSet per rendere modificabili i set
        Set<String> prodottiAlice = new HashSet<>(Set.of("Prodotto1", "Prodotto2", "Prodotto3"));
        Set<String> prodottiBob = new HashSet<>(Set.of("Prodotto2", "Prodotto3", "Prodotto4"));
        Set<String> prodottiCarol = new HashSet<>(Set.of("Prodotto1", "Prodotto4", "Prodotto5"));
        Set<String> prodottiDavid = new HashSet<>(Set.of("Prodotto2", "Prodotto5"));

        consigli.utenti.put("Alice", prodottiAlice);
        consigli.utenti.put("Bob", prodottiBob);
        consigli.utenti.put("Carol", prodottiCarol);
        consigli.utenti.put("David", prodottiDavid);

        // Proviamo a suggerire prodotti per un utente
        String utente = "Alice";
        Set<String> suggerimenti = consigli.suggerisciProdotti(utente);

        // Stampiamo i prodotti suggeriti
        System.out.println("Prodotti suggeriti per " + utente + ": " + suggerimenti);
    }
}


