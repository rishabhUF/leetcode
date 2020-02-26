package graphs;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    int V;
    List<Integer> adjListArray[];

    Graph(int v)
    {
        this.V = v;
        adjListArray = new LinkedList[v];
        // For each vertex we are making adjacency List
        for(int i=0;i<V;i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    void addEdge(Graph graph, int src, int dest) {
        graph.adjListArray[src].add(dest);
        graph.adjListArray[dest].add(src);
    }

    void printGraph(Graph graph) {
        for(int i=0;i< graph.adjListArray.length; i++) {
            System.out.println("Adjacency list of vertex "+ i);
            System.out.print("head");
            for(int j: graph.adjListArray[i]) {
                System.out.print(" -> "+j);
            }
            System.out.println("/n");
        }
    }

    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 4);
        graph.addEdge(graph, 1, 2);
        graph.addEdge(graph, 1, 3);
        graph.addEdge(graph, 1, 4);
        graph.addEdge(graph, 2, 3);
        graph.addEdge(graph, 3, 4);
        graph.printGraph(graph);
    }

    public void addDirectionalEdge(Graph g, int i, int i1) {
    }
}
