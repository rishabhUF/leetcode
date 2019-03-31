package trees;

public class ConvertBSTToGreaterSumTree {
	int sum = 0;
	TreeNode convertBST(TreeNode root) {
		if(root == null) {
			return null;
		}
		//1. Iterate over the Tree reverse order right root left
		//2. While Iterating over the tree add the values.
		TreeNode result = root;
		sumHelper(root);
		return result;
	}

	private void sumHelper(TreeNode root) {
		if(root == null) return;
		sumHelper(root.right);
		sum+= root.val;
		root.val = sum;
		sumHelper(root.left);
	}

	void printInorder(TreeNode node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}

	public static void main(String[] args) {
		ConvertBSTToGreaterSumTree convertBSTToGreaterSumTree = new ConvertBSTToGreaterSumTree();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(13);

		System.out.println("Inorder traversal of given tree ");
		convertBSTToGreaterSumTree.printInorder(root);
		TreeNode node = convertBSTToGreaterSumTree.convertBST(root);
		System.out.println("");
		System.out.println("Inorder traversal of modified tree ");
		convertBSTToGreaterSumTree.printInorder(node);
	}
}