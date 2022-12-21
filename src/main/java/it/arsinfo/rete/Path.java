package it.arsinfo.rete;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private final List<Node> path = new ArrayList<>();

    public void add(Node node) {
        path.add(node);
    }

    public List<Node> getPath() {
        return path;
    }

    public int getPathCost() {
        return path.get(0).getDijkstra();
    }

    public int getSteps() {
        return path.get(0).getDijkstra();
    }

    @Override
    public String toString() {
        String connectionPath = "";
        int n = path.size();
        int i = 0;
        for (Node node: path) {
            i++;
            connectionPath+= node.getId();
            if (i<n) {
                connectionPath+="->";
            }
        }
        return "Path{" +
                "path=" + connectionPath +
                "(cost:"+getPathCost()+", step:"+ getSteps() +")}";
    }
}
