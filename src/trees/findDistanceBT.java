package trees;

public class findDistanceBT {

    static int findDistanceBT(TreeNode root, int n1, int n2) {
        if(root == null)
            return -1;

    }

    static int findLevel(TreeNode root, int k, int level) {
        if(root == null)
            return -1;

        if(root.val == k)
            return level;

        int left = findLevel(root.left, k, level+1);
        return left!=-1 ? left : findLevel(root.right,k,level+1);
    }

    static TreeNode findLCA(TreeNode root, int n1, int n2) {
        if(root == null)
            return
    }
}
