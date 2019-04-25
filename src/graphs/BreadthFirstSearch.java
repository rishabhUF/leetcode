package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    void BFS(Graph graph, int s) {
        if(graph.adjListArray == null)
            return;
        int V = graph.adjListArray.length;
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while(!queue.isEmpty()) {
            int verter = queue.poll();
            for (int i : graph.adjListArray[verter]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
