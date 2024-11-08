package Frequenze;

import java.util.HashMap;
import java.util.LinkedList;

public class ContFreq {
    public HashMap<String,Integer> bag(String text)
    {
        //Le chiavi sono le parole nella frase
        //I valori sono il numero di volte in cui quella parola si ripete
        HashMap<String, Integer> count = new HashMap<>();

        text = text.toLowerCase();

        String[] words = text.split(" ");

        for(String word : words)
        {
            if(count.containsKey(word)){
                count.put(word, count.get(word)+1);
            }else {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }



        return count;
    }

    public LinkedList<String> frequenzeTOP(String text, int N){
        bag(text);
        LinkedList<String> frequenzet = new LinkedList<>();
        for(String word : bag(text).keySet()){
            if(bag(text).get(word) == N) //contatore = N
                frequenzet.add(word);
        }
        return frequenzet;
    }

    public static void main(String[] args) {
        ContFreq cf = new ContFreq();
        String s = "java e un bel programma java e";
        System.out.println(cf.frequenzeTOP(s, 2));
    }
}
