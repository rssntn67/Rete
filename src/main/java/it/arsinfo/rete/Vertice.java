package it.arsinfo.rete;

public class Vertice {
    private final int id;
    private String name;

    public Vertice(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertice vertice = (Vertice) o;

        return id == vertice.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
