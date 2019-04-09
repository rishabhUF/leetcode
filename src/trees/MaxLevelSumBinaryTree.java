package trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumBinaryTree {

    static int maxLevelSum(TreeNode root) {
        int sum = 0;
        if(root == null)
            return sum;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            int currentSum = 0;
            for(int i=0;i<n;i++) {
                TreeNode temp = queue.poll();
                currentSum+= temp.val;
                if(temp.left!= null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            sum = Math.max(currentSum, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(6);
        System.out.println("Hello " + maxLevelSum(root));
    }
}
