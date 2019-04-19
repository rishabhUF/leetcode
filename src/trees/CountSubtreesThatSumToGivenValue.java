package trees;

import static trees.TreeNode.insert;

public class CountSubtreesThatSumToGivenValue {

    static int countSubTree(TreeNode root, int n) {
        if(root == null)
            return 0;
        
        int[] result = new int[2];
        helper(root, n, result);
        return result[0];
    }

    static private int helper(TreeNode root, int n, int[] result) {
        if(root == null)
            return 0;
        int left = helper(root.left, n, result);
        int right = helper(root.right, n, result);
        int sum = left+right+root.val;
        if(sum == n) {
            result[0]++;
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        root = insert(root, 5);
        insert(root, -10);
        insert(root, 3);
        insert(root, 9);
        insert(root, 8);
        insert(root, -4);
        insert(root, 7);
        System.out.println(countSubTree(root,7));
    }
}
