package trees;

import static trees.TreeNode.insert;

public class LargestNumberinBSTLessThanN {

	static int largestNumberInBSTLessThanN(TreeNode root, int n) {

		if(root == null)
			return -1;
		if(root.left == null && root.right == null && root.val > n)
			return -1;
		else if(root.val <= n && (root.right == null || root.right.val > n))
			return root.val;
		else if(root.val > n)
			return largestNumberInBSTLessThanN(root.left, n);
		else
			return largestNumberInBSTLessThanN(root.right, n);
	}

	public static void main(String[] args) {
		int N = 4;

		// creating following BST
    /*
                5
            / \
            2     12
        / \ / \
        1 3 9 21
                    / \
                    19 25 */
		TreeNode root = null;
		root = insert(root, 25);
		insert(root, 2);
		insert(root, 1);
		insert(root, 3);
		insert(root, 12);
		insert(root, 9);
		insert(root, 21);
		insert(root, 19);
		insert(root, 25);

		System.out.println(largestNumberInBSTLessThanN(root, N));
	}
}
