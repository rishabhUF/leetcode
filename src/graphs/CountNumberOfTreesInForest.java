package graphs;

public class CountNumberOfTreesInForest {
    
    int countNumberOfTrees(Graph graph) {
        if(graph == null) 
            return 0;
        
        int res = 0;
        int v = graph.adjListArray.length;
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++) {
          if(!visited[i]) {
              DFSUtil(graph, i, visited);
              res++;
          }
        }
        return res;
    }

    private void DFSUtil(Graph graph, int i, boolean[] visited) {
        visited[i] = true;
        int v = graph.adjListArray[i].size();
        for(int j=0;j<v;j++) {
            int temp = graph.adjListArray[i].get(j);
            if(!visited[temp]) {
                DFSUtil(graph, temp, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        Graph g = new Graph(V);
        g.addDirectionalEdge(g,0, 1);
        g.addDirectionalEdge(g,0, 2);
        g.addDirectionalEdge(g,3, 4);
        CountNumberOfTreesInForest countNumberOfTreesInForest = new CountNumberOfTreesInForest();
        System.out.println(countNumberOfTreesInForest.countNumberOfTrees(g));
    }
}
