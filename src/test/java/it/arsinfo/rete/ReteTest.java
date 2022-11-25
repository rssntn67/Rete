package it.arsinfo.rete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReteTest {

    @Test
    public void testBuild() {
        GrafoBuilder builder = new GrafoBuilder();
        Grafo g = builder
                .add(0,1,1)
                .add(0,2,1)
                .add(0,3,3)
                .add(0,4,4)
                .add(1,3,1)
                .add(2,4,5)
                .add(3,4,1)
                .getGrafo();
        Assertions.assertEquals(5, g.getVertici().size(), "vertici");
        Assertions.assertEquals(7, g.getCollegamenti().size(), "collegamenti");
        System.out.println(g);
        Assertions.assertEquals(0, g.getDefaultVertex().getId(), "defaultVertex");
        g.computeDijkstra(g.getDefaultVertex());
        System.out.println(g);

    }
}
