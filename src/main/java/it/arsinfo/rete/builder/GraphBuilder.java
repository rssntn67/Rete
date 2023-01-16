package it.arsinfo.rete.builder;

import java.util.HashMap;
import java.util.Map;

import it.arsinfo.rete.model.Edge;
import it.arsinfo.rete.model.Graph;
import it.arsinfo.rete.model.Node;

public class GraphBuilder {
    private final NodeBuilder verticeBuilder= new NodeBuilder();
    private final EdgeBuilder collegamentoBuilder = new EdgeBuilder();

    private final Map<Integer, Node> vertici = new HashMap<>();

    private final Map<Integer , Edge> collegamenti = new HashMap<>();

    public GraphBuilder addNode(int vertex) {
        Node v = verticeBuilder.setId(vertex).setName("v:"+vertex).createVertice();
        if (!vertici.containsKey(vertex)) {
            vertici.put(vertex, v);
        }
        return this;
    }

    public GraphBuilder addEdge(int vertexA, int vertexB, int weight) {
        Node A = verticeBuilder.setId(vertexA).setName("v:"+vertexA).createVertice();
        if (vertici.containsKey(vertexA)) {
            A = vertici.get(vertexA);
        } else {
            vertici.put(vertexA, A);
        }
        Node B = verticeBuilder.setId(vertexB).setName("v:"+vertexB).createVertice();
        if (vertici.containsKey(vertexB)) {
            B = vertici.get(vertexB);
        } else {
            vertici.put(vertexB, B);
        }
        Edge AB = collegamentoBuilder.setTo(B).setFrom(A).setWeight(weight).createEdge();
        if (!collegamenti.containsKey(AB.hashCode())) {
            A.increaseDegree();
            B.increaseDegree();
            collegamenti.put(AB.hashCode(),AB);
        }
        return this;
    }

    public Graph getGrafo() {
        Graph g = new Graph();
        vertici.values().forEach(v -> g.getNodes().add(v));
        collegamenti.values().forEach(c -> g.getEdges().add(c));
        return g;
    }


    public static class NodeBuilder {
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

    public static class EdgeBuilder {
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
}
