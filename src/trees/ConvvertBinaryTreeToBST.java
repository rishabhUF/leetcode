package trees;

import java.util.Arrays;

public class ConvvertBinaryTreeToBST {

	public static void main() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(30);
		root.right = new TreeNode(15);
		convertToBST(root, 3);
	}
	static public TreeNode convertToBST(TreeNode binaryTreeRoot, int size) {
		//1. Convert temp array with inorder of Binary tree
		int[] temp = getInorder(binaryTreeRoot, size);
		//2. Sort the array got from inorder traversal
		Arrays.sort(temp);
		//3. Make the BST from Inorder list
		arrayToBST(temp, binaryTreeRoot, 0);
		return binaryTreeRoot;
	}

	static private void arrayToBST(int[] temp, TreeNode binaryTreeRoot, int index) {
		if(binaryTreeRoot == null) return;

		arrayToBST(temp, binaryTreeRoot.left, index);
		binaryTreeRoot.val = temp[index++];
		arrayToBST(temp, binaryTreeRoot.right, index);
	}

	static private int[] getInorder(TreeNode binaryTreeRoot, int size) {
		if(binaryTreeRoot == null || size < 1) {
			return null;
		}
		int[] result = new int[size];
		inorderTraversal(binaryTreeRoot, result, 0);
		return result;

	}

	static private void inorderTraversal(TreeNode binaryTreeRoot, int[] result, int index) {
		if(binaryTreeRoot == null) return;
		result[index] = binaryTreeRoot.val;
		inorderTraversal(binaryTreeRoot.left, result, index++);
		inorderTraversal(binaryTreeRoot.right, result, index++);
	}
}
