package it.arsinfo.rete;

import java.util.HashMap;
import java.util.Map;

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


}
