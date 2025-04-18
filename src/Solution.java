import java.util.*;

class main {
    public static List <Integer> bfsTraversal (Graph graph, int source) {
        List <Integer> result = new ArrayList<>();
        int numVertices = graph.vertices;
        boolean[] visited = new boolean[numVertices];
        Queue <Integer> queue = new Queue<>(numVertices);
        queue.enqueue(source);
        visited[source] = true;
        while (! queue.isEmpty()) {
            int currentVertex = queue.dequeue();
            result.add(currentVertex);

            EduLinkedList<Integer>.Node temp = graph.adjacencyList[currentVertex].headNode;
            while (temp != null) {
                if (!visited[temp.data]) {
                    visited[temp.data] = true;
                }
                temp = temp.nextNode;
            }
        }
        return result;
    }
    // Driver code
    public static void main(String[] args) {
        int[] graph_vertices = {5, 4, 6};
        int[][][][] graph_edges = {
                {{{0, 1, 2}, {2, 0, 3, 4}}},
                {{{0, 1, 2}, {2, 0, 3}}},
                {{{0, 1, 4}, {1, 2, 5}, {4, 3}, {3, 2}}}
        };
        int[] sources = {2, 0, 0};

        for (int i = 0; i < graph_vertices.length; i++) {
            Graph graph = new Graph(graph_vertices[i]);
            for (int j = 0; j < graph_edges[i][0].length; j++) {
                int source = graph_edges[i][0][j][0];
                for (int k = 1; k < graph_edges[i][0][j].length; k++) {
                    int destination = graph_edges[i][0][j][k];
                    graph.addEdge(source, destination);
                }
            }
            System.out.println((i + 1) + ".\t>>Adjacency List of the Graph<<\n");
            graph.printGraph();
            System.out.println("\n\tBFS Traversal starting from vertex " + sources[i] + ": " + bfsTraversal(graph, sources[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}