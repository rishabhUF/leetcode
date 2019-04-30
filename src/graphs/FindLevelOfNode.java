package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class FindLevelOfNode {

    int findLevel(Graph graph, int node) {
        if(graph == null)
            return -1;

        int v = graph.adjListArray.length;
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int temp = queue.poll();
                int vertexLen = graph.adjListArray[temp].size();
                visited[temp] = true;
                if(temp == node) {
                    return level;
                }
                for(int j=0;j<vertexLen;j++) {
                    int vertexValue = graph.adjListArray[temp].get(j);
                    if(!visited[vertexValue]) {
                        queue.offer(vertexValue);
                    }
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        int V = 5;
        Graph g = new Graph(V);
        g.addDirectionalEdge(g,0, 1);
        g.addDirectionalEdge(g,0, 2);
        g.addDirectionalEdge(g,3, 4);
        FindLevelOfNode findLevelOfNode = new FindLevelOfNode();
        System.out.println(findLevelOfNode.findLevel(g, 1));
    }
}
