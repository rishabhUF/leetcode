package trees;

public class LowestCommonAncestor {

    static TreeNode findLCA(TreeNode root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        if(root.val == n1 || root.val == n2) {
            return root;
        }

        TreeNode left = findLCA(root.left, n1, n2);
        TreeNode right = findLCA(root.right, n1, n2);

        if(left!= null && right!= null)
            return root;

        return left!=null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("LCA(4, 5) = " +
                findLCA(root,4, 5).val);
    }

}
