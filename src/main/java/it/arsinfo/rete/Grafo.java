package it.arsinfo.rete;

import java.util.HashSet;
import java.util.Set;

public class Grafo {
    private Set<Collegamento> collegamenti = new HashSet<>();

    public Set<Collegamento> getCollegamenti() {
        return collegamenti;
    }

    public void setCollegamenti(Set<Collegamento> collegamenti) {
        this.collegamenti = collegamenti;
    }
}
