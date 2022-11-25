package it.arsinfo.rete;

import java.util.Objects;

public class Collegamento {
    private final int costo;
    private final Vertice A;
    private final Vertice B;

    public Collegamento(int costo, Vertice a, Vertice b) {
        this.costo = costo;
        A = a;
        B = b;
    }

    public int getCosto() {
        return costo;
    }

    public Vertice getA() {
        return A;
    }

    public Vertice getB() {
        return B;
    }

    @Override
    public String toString() {
        return "Collegamento{" +
                "costo=" + costo +
                ", A=" + A +
                ", B=" + B +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Collegamento that = (Collegamento) o;

        if (!Objects.equals(A, that.A)) return false;
        return Objects.equals(B, that.B);
    }

    @Override
    public int hashCode() {
        int result = A != null ? A.hashCode() : 0;
        result = 31 * result + (B != null ? B.hashCode() : 0);
        return result;
    }
}
