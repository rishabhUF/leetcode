package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WaterJugProblem {

    boolean canMeasureWater(int x, int y, int z) {
        if(z < 0 || z > x + y)
            return false;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int[] options = new int[]{x,y,-x,-y};
        while(!queue.isEmpty()) {
            int s = queue.size();
            for(int i=0;i<s;i++) {
                int currentLevel = queue.poll();
                if(currentLevel == z) {
                    return true;
                }
                for(int o : options) {
                    int nextLevel = currentLevel + o;
                    if(nextLevel < 0 || nextLevel > x + y) {
                        continue;
                    }
                    if(!visited.contains(o)) {
                        queue.offer(nextLevel);
                        visited.add(nextLevel);
                    }
                }
            }
        }
        return false;
    }



    // This question can also be solved using the GCD look into the proof of that the lemma.
}
