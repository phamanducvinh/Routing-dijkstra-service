package impl;

import impl.Edge;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    private ArrayList<ArrayList<Edge>> neighbor;

    public Graph(ArrayList<Node> nodes,
                 ArrayList<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
        neighbor = new ArrayList<>();
        for(Node node : nodes) neighbor.add(new ArrayList<>());

        for(Edge edge : edges) {
            int u = edge.getStartNode().getNodeId();
            neighbor.get(u).add(edge);
        }
    }

    public ArrayList<ArrayList<Edge>> getNeighbor() {
        return neighbor;
    }

    public int getNumEdge() {
        return edges.size();
    }

    public int getNumNode() {
        return nodes.size();
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
}
