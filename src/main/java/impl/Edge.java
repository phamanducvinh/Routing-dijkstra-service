package impl;

public class Edge {
    private final Node startNode;
    private final Node endNode;

    private Double weight;

    public Edge(Node u, Node v, Double w) {
        this.startNode = u;
        this.endNode = v;
        this.weight = w;
    }

    public Edge(Node u, Node v) {
        this.startNode = u;
        this.endNode = v;
        this.weight = u.distance(v);
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public Double getWeight() {
        return weight;
    }
}
