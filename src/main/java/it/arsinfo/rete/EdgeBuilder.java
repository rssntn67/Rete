package it.arsinfo.rete;

public class EdgeBuilder {
    private Integer weight;
    private Node from;
    private Node to;
    private boolean directed = true;

    public EdgeBuilder setDirected(boolean directed) {
        this.directed = directed;
        return this;
    }

    public EdgeBuilder setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public EdgeBuilder setFrom(Node from) {
        this.from = from;
        return this;
    }

    public EdgeBuilder setTo(Node to) {
        this.to = to;
        return this;
    }

    public Edge createEdge() {
        return new Edge(weight, from, to, directed);
    }
}
