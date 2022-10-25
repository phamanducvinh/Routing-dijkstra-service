package impl;

import java.util.ArrayList;

public class DijkstraService {
    private final Node startRouting;
    private final Graph graph;
    private Double[] minPath;

    public static final Double INFINITY = Double.POSITIVE_INFINITY;

    public DijkstraService(Node startRouting, Graph graph) {
        this.startRouting = startRouting;
        this.graph = graph;
        minPath = new Double[graph.getNumNode()];
        for(Node node : graph.getNodes()) {
            minPath[node.getNodeId()] = INFINITY;
        }
        minPath[startRouting.getNodeId()] = 0.0;

        run();
    }

    private void run() {
        PriorityQueue<MinPath> pq = new PriorityQueue<>(graph.getNumEdge());
        ArrayList<ArrayList<Edge>> neighbor = graph.getNeighbor();

        int startId = startRouting.getNodeId();
        pq.push(new MinPath(startId,minPath[startId]));

        while (!pq.isEmpty()) {
            int u = pq.pop().getNodeId();
            for(Edge edge : neighbor.get(u)) {
                int v = edge.getEndNode().getNodeId();
                Double w = edge.getWeight();
                if(minPath[v] > minPath[u] + w) {
                    minPath[v] = minPath[u] + w;
                    pq.push(new MinPath(v,minPath[v]));
                }
            }
        }
    }

    public Double getMinPath(Node node) {
        return minPath[node.getNodeId()];
    }

    private class MinPath implements Comparable<MinPath> {
        private int nodeId;
        private Double weight;

        public MinPath(int node,Double weight) {
            this.nodeId = node;
            this.weight = weight;
        }

        public int getNodeId() {
            return nodeId;
        }

        @Override
        public int compareTo(MinPath that) {
            return (this.weight > that.weight ? -1 : 1);
        }
    }
}
