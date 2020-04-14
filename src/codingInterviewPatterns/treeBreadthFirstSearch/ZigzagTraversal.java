package codingInterviewPatterns.treeBreadthFirstSearch;
import java.util.*;


class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigZag = true;
        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0;i<n;i++) {
                TreeNode temp = queue.poll();
                if (zigZag) {
                    res.add(temp.val);
                } else {
                    res.add(0, temp.val);
                }
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
            }
            result.add(res);
            zigZag = !zigZag;
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
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
