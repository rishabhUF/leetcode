package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CountNumberOfNodesAtGivenLevel {

    int countNumberOfNodes(Graph g, int k) {
        int v = g.V;
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(g.adjListArray[0].get(0));
        int level = 0;
        while (!queue.isEmpty()) {
            if(level++ == k) {
                return queue.size();
            }
            int temp = queue.poll();
            visited[temp] = false;
            int len = g.adjListArray[temp].size();
            for(int i=0;i<len;i++) {
                if(visited[temp] == false)
                queue.offer(g.adjListArray[temp].get(i));
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int V = 7;
        Graph graph = new Graph(V);
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 1, 3);
        graph.addEdge(graph, 1, 4);
        graph.addEdge(graph, 2, 6);
        graph.printGraph(graph);
        CountNumberOfNodesAtGivenLevel countNumberOfNodesAtGivenLevel = new CountNumberOfNodesAtGivenLevel();
        System.out.println(countNumberOfNodesAtGivenLevel.countNumberOfNodes(graph, 2));
    }
}
