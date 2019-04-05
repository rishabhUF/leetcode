package trees;

public class MaxDifferenceBetweenNodeAndAncestorsBinaryTree {

	int getDifferenceBetweenNodeAndAncestorNode(TreeNode root, int[] diff) {
		if(root == null)
			return Integer.MAX_VALUE;
		if(root.left == null && root.right == null)
			return root.val;
		int left = getDifferenceBetweenNodeAndAncestorNode(root.left, diff);
		int right = getDifferenceBetweenNodeAndAncestorNode(root.right, diff);
		diff[0] = root.val-left > root.val-right ? root.val-left : root.val - right;
		int val = Math.min(left,right);
		return Math.min(val,root.val);
	}
}
