package it.arsinfo.rete;

import java.util.HashMap;
import java.util.Map;

public class GrafoBuilder {
    private VerticeBuilder verticeBuilder= new VerticeBuilder();
    private CollegamentoBuilder collegamentoBuilder = new CollegamentoBuilder();

    private final Map<Integer, Vertice> vertici = new HashMap<>();

    private final Map<Integer , Collegamento> collegamenti = new HashMap<>();

    public GrafoBuilder add(int vertexA, int vertexB, int costo) {
        Vertice A = verticeBuilder.setId(vertexA).setName("v"+vertexA).createVertice();
        if (vertici.containsKey(vertexA)) {
            A = vertici.get(vertexA);
        } else {
            vertici.put(vertexA, A);
        }
        Vertice B = verticeBuilder.setId(vertexB).setName("v"+vertexB).createVertice();
        if (vertici.containsKey(vertexB)) {
            B = vertici.get(vertexB);
        } else {
            vertici.put(vertexB, B);
        }
        Collegamento AB = collegamentoBuilder.setB(B).setA(A).setCosto(costo).createCollegamento();
        if (!collegamenti.containsKey(AB.hashCode())) {
            A.aggiungiCollegamento();
            A.aggiungiCosto(costo);
            B.aggiungiCollegamento();
            B.aggiungiCosto(costo);
            collegamenti.put(AB.hashCode(),AB);
        }
        return this;
    }

    public Grafo getGrafo() {
        Grafo g = new Grafo();
        vertici.values().forEach(v -> g.getVertici().add(v));
        collegamenti.values().forEach(c -> g.getCollegamenti().add(c));
        return g;
    }


}
