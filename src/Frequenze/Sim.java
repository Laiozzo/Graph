package Frequenze;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
//ESERCIZIO N°5
public class Sim
{
    public enum Permesso{
        LEGGERE, SCRIVERE, ESEGUIRE
    }

    public HashMap<String,HashMap<String, Set<Permesso> > > permessi;
    public HashMap<String, Set<Permesso> > utente;

    //La chiave della mappa esterna è il nome del file.
    //Il valore della mappa esterna è un'altra HashMap dove:

    public Sim(){
        permessi = new HashMap<>();
        utente = new HashMap<>();
    }

    public void aggiungiPermesso(String nomeFile, String nomeUtente, Permesso permesso){
        permessi.get(nomeFile).get(nomeUtente).add(permesso);
    }

    public void rimuviPermesso(String nomeFile, String nomeUtente, Permesso permesso){
        permessi.get(nomeFile).get(nomeUtente).remove(permesso);
    }

    public boolean hasPermesso(String nomeFile, String nomeUtente, Permesso permesso){
        return permessi.get(nomeFile).get(nomeUtente).contains(permesso);
    }

    public List<String> utentiConPermesso(String nomeFile, Permesso permesso){
        List<String> utenti = new ArrayList<>();
        for(String key : permessi.keySet()){
            if(hasPermesso(nomeFile, key, permesso)){
                for(String k : utente.keySet()){
                    if(hasPermesso(nomeFile, k, permesso)){
                        utenti.add(k);
                    }
                }
            }
        }
        return utenti;
    }

    public static void main(String[] args) {


    }
}
