package it.arsinfo.rete.model;

public class Node {

    private final int id;
    private final String name;

    private int degree = 0;
    private int dijkstra = -1;

    private Node parent = null;

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getDijkstra() {
        return dijkstra;
    }

    public void setDijkstra(int dijkstra) {
        this.dijkstra = dijkstra;
    }

    public Node(int id, String name) {
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

        Node vertice = (Node) o;

        return id == vertice.id;
    }

    //Number of connections
    public int getDegree() {
        return degree;
    }

    public void increaseDegree() {
        degree++;
    }


    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", degree=" + degree +
                (parent != null ? ", parent=" + parent.getId() : ", root") +
                "(dijkstra:" + dijkstra +
                ")}";
    }
}
