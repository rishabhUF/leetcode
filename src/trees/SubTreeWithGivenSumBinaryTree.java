package trees;

public class SubTreeWithGivenSumBinaryTree {
    static class result {
        boolean res;
    }
   static boolean checkSubTreeWithGivenSum(TreeNode root, int n)
    {
        if(root == null) {
            return false;
        }
        result result = new result();
        helper(root, n, result);
        return result.res;
    }

    static private int helper(TreeNode root, int n, result result) {
            if(root == null) {
                return 0;
            }
            int left = helper(root.left, n, result);
            int right = helper(root.right, n , result);
            if(left + right + root.val == n) {
                result.res = true;
            }
            return left + right + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        System.out.println(checkSubTreeWithGivenSum(root, 7));
    }
}
