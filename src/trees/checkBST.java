package trees;

public class checkBST {
	boolean checkBST(TreeNode root) {
		if(root == null) return true;
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean helper(TreeNode root, int minValue, int maxValue) {
		if(root == null) return true;
		if(root.val < minValue || root.val > maxValue) return false;
		return helper(root.left, minValue, root.val) && helper(root.right, root.val, maxValue);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(40);
		root.right = new TreeNode(30);
		checkBST checkBST = new checkBST();
		System.out.print(checkBST.checkBST(root));
	}
}
