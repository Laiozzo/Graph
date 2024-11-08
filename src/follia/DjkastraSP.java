package follia;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

public class DjkastraSP {

    //edgeTo -> Un array di DirectedEdge
    private DirectedEdge[] edgeTo;
    //disTo -> Un array di double che memorizza la distanza minima trovata fino a ciascun vertice
    private double[] distTo;
    //pq -> Una coda di priorità, che permette di gestire i nodi da esplorare in ordine di distanza minima
    private IndexMinPQ<Double> pq; //Vedere classe da qui si importa.

    //COSTRUTTORE
    public DjkastraSP(EdgeWeightedDiagraph G, int s)
    {
        //Inizializza un array di DirectedEdge e disTo con la dimensione del numero di vertici nel grafo (G.V())
        edgeTo = new DirectedEdge[G.V()]; //G -> grafo pesato con V() numero di vertici
        distTo = new double[G.V()]; //salviamo in distTo la distanza ?

        pq = new IndexMinPQ<Double>(G.V());

        for(int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY; // Settiamo TUTTE le distanze a infinito positivo.
        //TRANNE IL NODO DI PARTENZA s, che ha distanza di 0.0
        distTo[s] = 0.0;
        //Inseriamo s nella coda, PRONTI A PARTIRE?
        pq.insert(s, 0.0);
        //FINCHE pq non è vuota, rimuove il nodo con distanza minima e chiama il metodo relax() su di esso
        while(!pq.isEmpty())
            relax(G, pq.delMin());
    }
    //METODO RELAX:
    private void relax(EdgeWeightedDiagraph G, int v) {
        //PER OGNI collegamento diretto "e" che esce dla nodo v (ricordiamo che v è il nodo a distanza minima)
        //calcola se è possibile raggiungere il nodo "w" passando da "v";
        for(DirectedEdge e : G.adj(v))
        {
            int w = e.to();
            if(distTo[w] > distTo[v] + e.weight())
            {
                //Se troviamo un percorso più breve, aggiorna disTo[w], edgeTo[w] e modifica la priorità del nodo w nella coda.
                //Ma quindi non si ferma se trova w, perché vuole effettivamente il percorso più breve, non gli va bene il primo che trova.
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if(pq.contains(w)) pq.changeKey(w, distTo[w]);
                else               pq.insert(w, distTo[w]);
            }
        }
    }
    public double disTo(int v)//Standard client query methods
    {   return distTo[v];}

    public boolean hasPathTo(int v) //for SPT implementations
    {   return pq.contains(v);}

    //pathTo crea un cammino inverso dal nodo v al nodo di partenza s.
    //utilizzando la struttura edgeTo. Permettendo di tracciare il percorso inverso fino al nodo di origine
    public Iterable<DirectedEdge> pathTo(int v)
    {
        if(!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for(DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) //Sembra un for-each ma bada bene non lo è minimamente;
            path.push(e);
        return path;
    }
}
