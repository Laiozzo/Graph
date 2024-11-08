package controller;
import java.util.*;
import edu.princeton.cs.algs4.*;
import follia.DirectedEdge;
import follia.EdgeWeightedDiagraph;
import follia.*;
public class Main
{
    public static void main(String[] args) {
        //DOBBIAMO CONVERTIRE L'HASHMAP in modo che sia leggibile dalla classe EdgeWeightedDiagraph, ci riusciremo? BOH
        /*
        PROBLEMS: EDGEWEIGHTEDDIAGRAPH richiede nodi INDICIZZATI con numeri interi, mentre inputMap utilizza stringhe come
        identificator di nodi

        nodesIndici -> Mappa ogni nodo nodo String a un indice Integer unico

        Creazione del grafo con EDGEWEIGHTEDDIAGRAPH della dimensione del numero totale di nodi

        AGGIUNTA di archi con DirectEdge:
                    per ogni nodo sorgente della inputMap, si crea un DirectedEdge dal nodo sorgente(sourceIndex)
                    al nodo di destinazione (destinationIndex) con il peso fornito.

                    Ogni DirectedEdge viene aggiunto al grafo EDGEetc.etc.
         */


        HashMap<String, HashMap<String,Integer>> inputMap = new HashMap<>();

        //Mettiamo dei dati
        HashMap<String,Integer> edgesA = new HashMap<>();
        edgesA.put("B", 5);
        edgesA.put("C", 9);
        edgesA.put("A", 2 );

        HashMap<String,Integer> edgesB = new HashMap<>();
        edgesB.put("C", 2);
        //Hashmap inizializzato
        inputMap.put("A", edgesB);

        //Mappa per tenere traccia della corrispondenza tra nodi e indici:
        Map<String, Integer> nodesIndici = new HashMap<>();
        int index = 0;

        //Assegnamo un indice unico a ciascun nodo
        for(String node : inputMap.keySet()){
            if(!nodesIndici.containsKey(node)){
                nodesIndici.put(node,index++);
            }
            for(String vicine : inputMap.get(node).keySet()){
                if(!nodesIndici.containsKey(vicine)){
                    nodesIndici.put(vicine,index++);
                }
            }
        }

        //ORA POSSIAMO CREARE IL GRAFO YEAHHHHHHHHHHHHHHHH!!
        EdgeWeightedDiagraph graph = new EdgeWeightedDiagraph(nodesIndici.size());

        //Aggiungiamo i legami al grafo:
        for(String source : nodesIndici.keySet()){
            int sourceIndex = nodesIndici.get(source);
            for(Map.Entry<String, Integer> entry : inputMap.get(source).entrySet())
            {
                String destination = entry.getKey();
                int destinationIndex = nodesIndici.get(destination);
                int weight = entry.getValue();
                DirectedEdge edge = new DirectedEdge(sourceIndex, destinationIndex, weight);
                graph.addEdge(edge);
            }
        }

        //Stampa grafo
        System.out.println(graph);

        DjkastraSP follia = new DjkastraSP(graph,0);
    }
}
