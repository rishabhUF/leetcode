package trees;

public class MaximumSumLeafToRootPath {

    class Sum {
        int curSum;
    }
    Sum res = new Sum();

    int findMaxSumLeaf(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return root.val;
        }

        int left = findMaxSumLeaf(root.left);
        int right = findMaxSumLeaf(root.right);
        res.curSum+= root.val + Math.max(left,right);
        return root.val + Math.max(left,right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        MaximumSumLeafToRootPath maximumSumLeafToRootPath = new MaximumSumLeafToRootPath();
        System.out.println(maximumSumLeafToRootPath.findMaxSumLeaf(root));
    }
}
