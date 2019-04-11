package trees;

public class SumOfLeafNodes {

    static int getLeafSum(TreeNode root) {
        int result = 0;
        if(root == null)
            return result;
        if(root.left == null && root.right == null) {
            result+= root.val;
            return result;
        }
        return getLeafSum(root.left) + getLeafSum(root.right);
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
        System.out.print(getLeafSum(root));
    }
}
