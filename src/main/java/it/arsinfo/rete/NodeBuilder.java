package it.arsinfo.rete;

public class NodeBuilder {
    private int id;
    private String name;

    public NodeBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public NodeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Node createVertice() {
        return new Node(id, name);
    }
}
