package follia;

public class DirectedEdge
{
    private final int v; //edge tail
    private final int w; //edge head
    private final double weight; //edge weight

    public DirectedEdge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    //Peso del legame
    public double weight(){ return weight; }
    //Da dove veniamo
    public int from(){ return v; }
    //dove stiamo andando
    public int to(){ return w; }

    /**
     * format è un metodo che crea una stringa
     * formattata seguendo specifici parametri.
     * %d: indica un segnaposto per un numero intero -> v;
     * %.2f: un segnaposto per un numero in virgola mobile con due cifre decimali -> weight
     * Se v = 1, w = 2 e weight = 3.14159 il metodo restituisce la stringa:
     * "1 2 3.14"
     * @return
     */
    public String toString(){return String.format("%d %.2f", v, w, weight);}

}
