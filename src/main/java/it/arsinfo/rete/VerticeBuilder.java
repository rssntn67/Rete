package it.arsinfo.rete;

public class VerticeBuilder {
    private int id;

    public VerticeBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public Vertice createVertice() {
        return new Vertice(id);
    }
}
