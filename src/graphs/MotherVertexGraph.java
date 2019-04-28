package graphs;

public class MotherVertexGraph {

    int motherVertex(Graph graph) {

        if(graph == null) {
            return -0;
        }
        int v = graph.V;
        int lastVisited = 0;
        boolean[] visited = new boolean[v];
        for(int i=0; i < v ; i++) {
            if(visited[i] == false) {
                DFSUtil(graph, i, visited);
                lastVisited = i;
            }
        }

        // Now check the above lastVisited node is mother node or not
        boolean[] checkVisited = new boolean[v];
        DFSUtil(graph, lastVisited, checkVisited);
        for(int i=0;i<v;i++) {
            if(checkVisited[i] == false)
                return -1;
        }
        return lastVisited;
    }

    private void DFSUtil(Graph graph, int i, boolean[] visited) {
        visited[i] = true;
        int v = graph.adjListArray[i].size();
        for(int j=0;j<v;j++) {
            if(visited[graph.adjListArray[i].get(j)] == false) {
                DFSUtil(graph, graph.adjListArray[i].get(j), visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        MotherVertexGraph motherVertexGraph = new MotherVertexGraph();
        Graph g = new Graph(V);
        g.addDirectionalEdge(g,0, 1);
        g.addDirectionalEdge(g,0, 2);
        g.addDirectionalEdge(g,1, 3);
        g.addDirectionalEdge(g,4, 1);
        g.addDirectionalEdge(g,6, 4);
        g.addDirectionalEdge(g,5, 6);
        g.addDirectionalEdge(g,5, 2);
        g.addDirectionalEdge(g,6, 0);
        g.printGraph(g);
        System.out.println(motherVertexGraph.motherVertex(g));
    }
}
