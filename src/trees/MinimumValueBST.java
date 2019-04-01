package trees;

public class MinimumValueBST {
	int findMinBST(TreeNode root) {
		if(root == null) {
			return -1;
		}
		if(root.left == null) {
			return root.val;
		}
		int result = findMinBST(root.left);
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		MinimumValueBST minimumValueBST = new MinimumValueBST();
		System.out.print(minimumValueBST.findMinBST(root));

	}
}
