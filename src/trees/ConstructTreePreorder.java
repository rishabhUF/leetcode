package trees;

// TreeNode class
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int v) {
		this.val = v;
		this.left = null;
		this.right = null;
	}

	static TreeNode insert( TreeNode root, int key)
	{
		if (root == null)
			return new TreeNode(key);
		if (root.val > key)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;
	}
}
class Index {
	int index = 0;

	public Index() {}
	public Index(int index ) {
		this.index = index;
	}
}

class BinaryTree {
	Index index = new Index();

	TreeNode contructTreeUtil(int pre[], Index preIndex, int key, int min, int max, int size) {
		//Base case
		if (preIndex.index >= size)
			return null;
		TreeNode root = null;

		if (key > min && key < max) {
			root = new TreeNode(key);
			preIndex.index = preIndex.index + 1;

			if (preIndex.index < size) {
				root.left = contructTreeUtil(pre, preIndex, pre[preIndex.index], min, key, size);
				root.right = contructTreeUtil(pre, preIndex, pre[preIndex.index], key, max, size);
			}
		}
		return root;
	}

	TreeNode constructTree(int pre[], int size) {
		int preIndex = 0;
		return contructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
	}

	void printInorder(TreeNode node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}


}

public class ConstructTreePreorder {
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		int size = pre.length;
		TreeNode root = tree.constructTree(pre, size);
		tree.printInorder(root);
	}
}
