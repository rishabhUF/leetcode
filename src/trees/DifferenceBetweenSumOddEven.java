package trees;

import java.util.LinkedList;
import java.util.Queue;

public class DifferenceBetweenSumOddEven {

    int difference(TreeNode root) {
        if(root == null)
            return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int oddSum = 0, evenSum = 0, level = 1;
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i=0;i<n;i++) {
                TreeNode temp = queue.poll();
                if(level%2 == 0) {
                    evenSum+= temp.val;
                } else {
                    oddSum+= temp.val;
                }
                if(temp.left!= null)
                    queue.offer(temp.left);
                if(temp.right!= null)
                    queue.offer(temp.right);
            }
            level++;
        }
        return evenSum - oddSum;
    }



}
