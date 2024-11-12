package Frequenze;

//ESERCIZIO N°6

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Consigli
{
    //String = utente;

    HashMap<String, Set<String>> frequenze;
    Set<String> res;

    public Consigli(){
        frequenze = new HashMap<>();
        res = new HashSet<>();
    }

    public void setRes(String res){
        this.res.add(res);
    }

    public Set<String> suggerisciProdotti(String utente)
    {

        return res;
    }



}
