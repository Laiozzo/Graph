package follia;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;

public class EdgeWeightedDiagraph {

    private final int V; //numero di vertici
    private int E; //numero di edges (di legami)
    private Bag<DirectedEdge>[] adj; //Lista di adiacenza

    public EdgeWeightedDiagraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V]; //Creiamo la Lista di adiacenza in cui mettiamo il numero di vertici, giusto?
        for(int v = 0; v < V; v++)
        {
            adj[v] = new Bag<DirectedEdge>(); // cicliamo i vertici e inseriamo i vertici nella bag;
        }

    }

    public int V(){return V;}
    public int E(){return E;}

    /**
     * Aggiungiamo un nuovo legame
     * YepaJaaaaa
     * Che figata!!!
     * @param e
     */
    public void addEdge(DirectedEdge e){
        adj[e.from()].add(e); //Allora e.from() ci dice la coda di e (da dove veniamo) restituisce percio un oggetto DirectedEdge alla quale facciamo il metodo add.e aggiungiamo la testa alla coda dunque
        E++; //Andiamo ad aumentare la lista di legami, abbiamo aggiunto un nuovo legame!!
    }

    /**
     * iteriamo(facciamo un ciclo for) per vedere tutti i legami del vertice all'indice v, credo
     * @param v
     * @return
     */
    public Iterable<DirectedEdge> adj(int v){return adj[v];} //Allora i cicli for sono per chi non è in grado di usare l'interfaccia Iterable


    /**
     * Ma quindi il tipo restituito è un Iterable<DirectedEdge>?
     * Non molto chiaro
     * Incredibile come in questa borsa possiamo metterci di tutto
     * @return
     */
    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
        for(int v = 0; v < V; v++)
        {
            for(DirectedEdge e : adj[v])
                bag.add(e);
        }
        return bag;
    }


}
