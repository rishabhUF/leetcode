package trees;

public class ConvertBSTToSmallerSumTree {

	int sum = 0;

	TreeNode convertBST(TreeNode root) {
		if(root == null) {
			return null;
		}
		TreeNode result = root;
		convertBSTHelper(root);
		return result;
	}

	private void convertBSTHelper(TreeNode root) {
		if(root == null)
			return;
		convertBSTHelper(root.left);
		sum+= root.val;
		root.val = sum;
		convertBSTHelper(root.right);
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
		ConvertBSTToSmallerSumTree convertBSTToSmallerSumTree = new ConvertBSTToSmallerSumTree();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(13);

		System.out.println("Inorder traversal of given tree ");
		convertBSTToSmallerSumTree.printInorder(root);
		TreeNode node = convertBSTToSmallerSumTree.convertBST(root);
		System.out.println("");
		System.out.println("Inorder traversal of modified tree ");
		convertBSTToSmallerSumTree.printInorder(node);
	}

}
