package it.arsinfo.rete;

public class Vertice {

    private final int id;
    private final String name;

    private int collegamenti = 0;
    private int costo = 0;

    public int getDijkstra() {
        return dijkstra;
    }

    public void setDijkstra(int dijkstra) {
        this.dijkstra = dijkstra;
    }

    private int dijkstra = -1;

    Vertice(int id, String name) {
        this.id = id;
        this.name= name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertice vertice = (Vertice) o;

        return id == vertice.id;
    }

    public int getNumeroCollegamenti() {
        return collegamenti;
    }

    public void aggiungiCollegamento() {
        collegamenti++;
    }

    public int getCosto() {
        return costo;
    }

    public void aggiungiCosto(int costo) {
        this.costo += costo;
    }

    public float getPeso() {
        if (collegamenti == 0 )
            return Float.parseFloat("10000000000.0");
        if (costo == 0)
            return Float.parseFloat("0.0");
        return (float) costo/collegamenti;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", collegamenti=" + collegamenti +
                ", costo=" + costo +
                ", peso=" + getPeso() +
                ", dijkstra=" + getDijkstra() +
                '}';
    }
}
