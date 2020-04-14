package codingInterviewPatterns.treeBreadthFirstSearch;
import java.util.*;

public class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if(root == null)
            return root;

        TreeNode result = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundKey = false;
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i=0;i<n;i++) {
                TreeNode temp = queue.poll();
                if(foundKey) {
                    return temp;
                }
                if(temp.val == key) {
                    foundKey = true;
                }
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 5);
        if (result != null)
            System.out.println(result.val + " ");
    }
}
