import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by jackkates on 2/9/16.
 */
public class Main {

    public int N;
    public int[][] distances;
    Scanner sc;

    public static void main(String[] args) {
        new Main().run();
    }

    public Main() {}

    public void run() {
        sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int shortestPath = findShortestPath();
            System.out.println(shortestPath);
        }
    }

    private void loadMatrix() {

        N = sc.nextInt();
        distances = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distances[i][j] = sc.nextInt();
            }
        }
    }

    private int findShortestPath() {
        loadMatrix();

        int pathLength = 0;
        Set<Integer> vertexSet = new HashSet<Integer>();

        // Add the first vertex (#0) to the spanning tree.
        vertexSet.add(0);

        // Until the tree is spanning (|MST| = N), add the shortest edge.
        while (vertexSet.size() != N) {
            Edge shortestEdge = new Edge(100001);
            for (Integer source : vertexSet) {
                for (int dest = 0; dest < N; dest++) {
                    int distance = distances[source][dest];
                    if (!vertexSet.contains(dest) && distance < shortestEdge.length && distance > 0) {
                        shortestEdge.length = distance;
                        shortestEdge.sourceVertex = source;
                        shortestEdge.destinationVertex = dest;
                    }
                }
            }
            // Add the shortest edge to the tree.
            vertexSet.add(shortestEdge.destinationVertex);
            // Add the length of the shortest edge to the path.
            pathLength += shortestEdge.length;
        }

        return pathLength;
    }

    public class Edge {
        public int length;
        public int sourceVertex;
        public int destinationVertex;

        public Edge() {
            this(0, 0, 0);
        }

        public Edge (int length) {
            this(length, 0, 0);
        }

        public Edge(int length, int sourceVertex, int destinationVertex) {
            this.length = length;
            this.sourceVertex = sourceVertex;
            this.destinationVertex = destinationVertex;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "length=" + length +
                    ", sourceVertex=" + sourceVertex +
                    ", destinationVertex=" + destinationVertex +
                    '}';
        }
    }
}
