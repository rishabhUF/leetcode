package trees;

public class SortedListToBST {

	TreeNode convertToBST(int[] arr) {
		if (arr == null || arr.length == 0)
			return null;

		TreeNode root = helper(arr, 0, arr.length - 1);
		return root;
	}

	TreeNode helper(int[] arr, int left, int right) {
		//base case
		if (left > right) {
			return null;
		}
		if (left == right) {
			return new TreeNode(arr[left]);
		}
		int index = right - (right + left) / 2;
		TreeNode root = new TreeNode(arr[left + index]);
		root.left = helper(arr, left, (left + index) - 1);
		root.right = helper(arr, left + index + 1, right);
		return root;
	}

	void preOrder(TreeNode node) {
		if (node == null)
			return;
		preOrder(node.left);
		System.out.print(node.val + " ");
		preOrder(node.right);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1,2,3,4,5,6,7 };
		SortedListToBST tree = new SortedListToBST();
		TreeNode root = tree.convertToBST(arr);
		tree.preOrder(root);
	}
}
