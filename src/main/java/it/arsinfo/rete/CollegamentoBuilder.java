package it.arsinfo.rete;

public class CollegamentoBuilder {
    private int costo;
    private Vertice a;
    private Vertice b;

    public CollegamentoBuilder setCosto(int costo) {
        this.costo = costo;
        return this;
    }

    public CollegamentoBuilder setA(Vertice a) {
        this.a = a;
        return this;
    }

    public CollegamentoBuilder setB(Vertice b) {
        this.b = b;
        return this;
    }

    public Collegamento createCollegamento() {
        return new Collegamento(costo, a, b);
    }
}
