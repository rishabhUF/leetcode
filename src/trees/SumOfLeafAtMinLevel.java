package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeafAtMinLevel {

    static int sumOfLeafAtMinLevel(TreeNode root) {
        if(root == null)
            return 0;
//        if(root.left == null && root.right == null)
//            return root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        boolean check = false;
        while(!queue.isEmpty()) {
            int n = queue.size();
            int sum = 0;
            for(int i=0; i<n; i++) {
                TreeNode temp = queue.poll();
                if(temp.left == null && temp.right ==null) {
                    sum += temp.val;
                    check = true;
                }
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
            }
            if(check){
                result = sum;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);
        System.out.print(sumOfLeafAtMinLevel(root));
    }
}
