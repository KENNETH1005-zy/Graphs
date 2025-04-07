public class Graph {
    int vertices; //Total number of vertices in graph
    EduLinkedList < Integer > adjacencyList[]; //An array of linked lists to store adjacent vertices.

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new EduLinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new EduLinkedList < > ();
        }
    }

    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].insertAtEnd(destination);

            //for undirected graph uncomment the line below
            //this.adjacencyList[destination].insertAtEnd(source);
        }
    }
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            if (adjacencyList[i] != null) {
                System.out.print("\t|" + i + "| => ");

                EduLinkedList < Integer > .Node temp = adjacencyList[i].getHeadNode();
                while (temp != null) {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            } else {

                System.out.println("|" + i + "| => " + "null");
            }
        }
    }
}