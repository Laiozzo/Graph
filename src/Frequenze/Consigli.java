package Frequenze;

//ESERCIZIO N°6

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Consigli
{
    //String = utente;

    public HashMap<String, Set<String>> utenti;
    public Set<String> acquisti;

    public Consigli(){
        utenti = new HashMap<>();
        acquisti = new HashSet<>();
    }

    public void setRes(String res){
        this.acquisti.add(res);
    }

    public Set<String> suggerisciProdotti(String utente)
    {
        Set<String> bag = new HashSet<String>();
        for(String users : utenti.keySet()){
            //Se la lista di utenti == utente inserito come argomento:
            if(utenti.get(users).contains(utente)){
                //Metti tutti i prodotti dell'utente nella bag
                for(String prodotti : utenti.get(users)){
                    bag.add(prodotti);
                }
            }
        }
        //Ora abbiamo la bag piena degli acquisti. Ora dobbiamo comparare con gli altri utenti.
        Set<String> injection = new HashSet<>();
        for(String users : utenti.keySet()){
            for(String prodotti : utenti.get(users)){
                //Qui arriva la parte complessa:
                //Se nell'HashMap Utenti troviamo un utente che ha degli acquisti in comune con il nostro utente:
                if(utenti.get(users).removeAll(bag)){
                    //Qui c'è un problema. utenti.get(users) -> aggiorna automaticamente il Set<String>
                    //Svolgo il problema come se ciò non succedesse.
                    injection.add(utenti.get(users).iterator().next());
                    //Qua si salva sicuramente il risultato e togliamo gli oggetti di bag da injection.
                    injection.removeAll(bag);
                    //Inseriamo gli oggetti non acquistati nella bag
                    bag.add(injection.iterator().next());
                    //ripeti il ciclo finche non finiscono tutti gli utenti.
                }
            }
        }
        return bag;
    }



}
