import impl.DijkstraService;
import impl.Edge;
import impl.Graph;
import impl.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(Main.class.getResource("input.txt").getPath());
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        ArrayList<Node> realNodes = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0;i<n;++i) realNodes.add(new RealNode(i));
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            Double w = scanner.nextDouble();
            System.out.println(u+" " + v + " " + w);
            edges.add(new Edge(realNodes.get(u),realNodes.get(v),w));
            edges.add(new Edge(realNodes.get(v),realNodes.get(u),w));
        }

        Graph graph = new Graph(realNodes,edges);
        DijkstraService dijkstraService = new DijkstraService(realNodes.get(0),graph);
        for(int i=1 ;i<n;++i) {
            System.out.println("Min path to node " + (i) + ":" + dijkstraService.getMinPath(realNodes.get(i)));
        }
    }
}
