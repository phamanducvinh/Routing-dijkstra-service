package impl;

public abstract class Node {
    private final int nodeId;

    public Node(int nodeId) {
        this.nodeId = nodeId;
    }

    public int getNodeId() {
        return nodeId;
    }

    public abstract Double distance(Node o);

    @Override
    public String toString() {
        return String.valueOf(nodeId);
    }
}
