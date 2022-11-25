package it.arsinfo.rete;

public class VerticeBuilder {
    private int id;
    private String name;

    public VerticeBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public VerticeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Vertice createVertice() {
        return new Vertice(id, name);
    }
}
