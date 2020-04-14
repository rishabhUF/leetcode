package codingInterviewPatterns.treeBreadthFirstSearch;
import java.util.*;
public class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        // This is the BFS approach. This question can be done different approaches.
        // TODO: Top Down vs bottom up vs recursion vs iteration
        // This individual question will help me to understand these all approaches.

        if(root == null)
            return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            minDepth++;
            for(int i=0;i<n;i++) {
                TreeNode temp = queue.poll();
                if(temp.left == null && temp.right == null) {
                    return minDepth;
                }
                if(temp.left!=null) {
                    queue.offer(temp.left);
                }
                if(temp.right!=null) {
                    queue.offer(temp.right);
                }
            }
        }
        return minDepth;
    }

    public static int findMaxDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            maxDepth++;
            for(int i=0;i<n;i++) {
                TreeNode temp = queue.poll();
                if(temp.left!=null) {
                    queue.offer(temp.left);
                }
                if(temp.right!=null) {
                    queue.offer(temp.right);
                }
            }
        }
        return maxDepth;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        System.out.println("Tree Maximum Depth: " + MinimumBinaryTreeDepth.findMaxDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        System.out.println("Tree Maximum Depth: " + MinimumBinaryTreeDepth.findMaxDepth(root));
    }
}
