package trees;

public class SumOfAllNodes {
    int[] res = new int[1];
    int findSumOfNodes(TreeNode root) {
        if(root == null)
            return 0;
        helper(root, res);
        return res[0];
    }

    private void helper(TreeNode root, int[] res) {
        if(root == null)
            return;

        res[0] += root.val;
        helper(root.left,res);
        helper(root.right,res);
    }
}
