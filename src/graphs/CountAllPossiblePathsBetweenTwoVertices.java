package graphs;

public class CountAllPossiblePathsBetweenTwoVertices {

    int numberOfpaths(Graph graph, int u, int v) {
        int vertex = graph.V;
        boolean[] visited = new boolean[vertex];

        int countPaths = 0;
        DFSUtils(graph, u, v, visited, countPaths);
        return countPaths;

    }

    private int DFSUtils(Graph graph, int u, int v, boolean[] visited, int countPaths) {
        visited[u] = true;
        if(u == v) {
            countPaths++;
        }
        else {
            int len = graph.adjListArray[u].size();
            for(int i=0;i<len;i++) {
                int vertexToVisit = graph.adjListArray[u].get(i);
                if(visited[vertexToVisit] == false) {
                    DFSUtils(graph, u, v, visited, countPaths);
                }
            }
        }
        visited[u] = false;
        return countPaths;
    }
}
