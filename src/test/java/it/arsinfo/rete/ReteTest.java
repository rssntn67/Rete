package it.arsinfo.rete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import it.arsinfo.rete.builder.GraphBuilder;
import it.arsinfo.rete.model.Graph;
import it.arsinfo.rete.model.Node;
import it.arsinfo.rete.model.Path;

public class ReteTest {

    @Test
    public void testBuild() {
        GraphBuilder builder = new GraphBuilder();
        Graph g = builder
                .addNode(0)
                .addNode(1)
                .addNode(2)
                .addNode(3)
                .addNode(4)
                .addEdge(0,1,1)
                .addEdge(0,2,1)
                .addEdge(0,3,3)
                .addEdge(0,4,4)
                .addEdge(1,3,1)
                .addEdge(2,4,5)
                .addEdge(3,4,1)
                .getGrafo();
        /*
         *              1
         *           /  |
         *        4-3---0----4
         *              |    |
         *              2----
         *
         * D0=0
         * D1=1 -> 0-1
         * D2=1 -> 0-2
         * D3=2 -> 0-1-3
         * D4=3 -> 0-1-3-4
         *     2
         *     |
         *     0
         *     |
         *     1
         *     |
         *     3
         *     |
         *     4
         */
        Assertions.assertEquals(5, g.getNodes().size(), "vertici");
        Assertions.assertEquals(7, g.getEdges().size(), "collegamenti");
        System.out.println(g);
        Assertions.assertEquals(0, g.getDefaultVertex().getId(), "defaultVertex");
        g.computeDijkstra(g.getDefaultVertex());
        System.out.println(g);
        for (Node node : g.getNodes()) {
            switch (node.getId()) {
                case 0 -> Assertions.assertEquals(0, node.getDijkstra());
                case 1, 2 -> Assertions.assertEquals(1, node.getDijkstra());
                case 3 -> Assertions.assertEquals(2, node.getDijkstra());
                case 4 -> Assertions.assertEquals(3, node.getDijkstra());
                default -> Assertions.fail();
            }
        }

        Node node4 = g.getbyNodeId(4);
        Node node2 = g.getbyNodeId(2);
        g.computeDijkstra(node2);
        System.out.println(g);
        for (Node node : g.getNodes()) {
            switch (node.getId()) {
                case 2 -> Assertions.assertEquals(0, node.getDijkstra());
                case 0 -> Assertions.assertEquals(1, node.getDijkstra());
                case 1 -> Assertions.assertEquals(2, node.getDijkstra());
                case 3 -> Assertions.assertEquals(3, node.getDijkstra());
                case 4 -> Assertions.assertEquals(4, node.getDijkstra());
                default -> Assertions.fail();
            }
        }

        Path path = g.getPath(node4, node2);
        System.out.println(path);
        Assertions.assertEquals(4, path.getPathCost());
        Assertions.assertEquals(4, path.getSteps());
        Assertions.assertEquals(5, path.getPath().size());
        Assertions.assertEquals(4, path.getPath().get(0).getId());
        Assertions.assertEquals(3, path.getPath().get(1).getId());
        Assertions.assertEquals(1, path.getPath().get(2).getId());
        Assertions.assertEquals(0, path.getPath().get(3).getId());
        Assertions.assertEquals(2, path.getPath().get(4).getId());

    }
}
