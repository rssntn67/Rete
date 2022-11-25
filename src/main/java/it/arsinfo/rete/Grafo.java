package it.arsinfo.rete;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Grafo {

    private final Set<Vertice> vertici = new HashSet<>();

    private final Set<Collegamento> collegamenti = new HashSet<>();

    public Set<Vertice> getVertici() {
        return vertici;
    }

    public Set<Collegamento> getCollegamenti() {
        return collegamenti;
    }

    public void computeDijkstra(Vertice sv) {
        final Set<Vertice> u = new HashSet<>();
        vertici.forEach(v -> {
            v.setDijkstra(-1);
            u.add(v);
        });
        sv.setDijkstra(0);
        if (!u.remove(sv)) {
            return;
        }
        Map<Integer,Integer> cmap = collegamenti.stream().collect(Collectors.toMap(Collegamento::hashCode, Collegamento::getCosto));
        stepForward(u,cmap,sv);
    }

    private void stepForward(Set<Vertice> u, Map<Integer,Integer> cmap, Vertice v ) {
        Set<Vertice> uv = new HashSet<>();
        for (Vertice vk : u) {
            Integer c = null;
            if (cmap.containsKey(getHash(v.getId(), vk.getId()))) {
                c = cmap.remove(getHash(v.getId(), vk.getId()));
            } else if (cmap.containsKey(getHash(vk.getId(), v.getId()))) {
                c = cmap.remove(getHash(vk.getId(), v.getId()));
            }
            if (c == null) {
                continue;
            }
            uv.add(vk);
            if (vk.getDijkstra() == -1 || vk.getDijkstra() > c + v.getDijkstra()) {
                vk.setDijkstra(c + v.getDijkstra());
            }
        }
        for (Vertice vv: uv) {
            u.remove(vv);
            stepForward(u, cmap, vv);
        }
    }

    private static int getHash(int v1, int v2) {
        int result = v1;
        result = 31 * result + v2;
        return result;
    }
    public Vertice getDefaultVertex() {
        Vertice d = null;
        for (Vertice v : vertici) {
            if (d == null) {
                d = v;
                continue;
            }
            if (d.getNumeroCollegamenti() > v.getNumeroCollegamenti()) {
                continue;
            }
            if (d.getNumeroCollegamenti() == v.getNumeroCollegamenti() && d.getPeso() < v.getPeso()) {
                continue;
            }
            d = v;
        }
        return d;
    }
    @Override
    public String toString() {
        return "Grafo{" +
                "vertici=" + vertici +
                ", collegamenti=" + collegamenti +
                '}';
    }
}
