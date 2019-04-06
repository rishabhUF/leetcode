package trees;

import sun.reflect.generics.tree.Tree;

public class PrintPathFromRootToNode {

	static boolean findPath(TreeNode root, int target) {
		if(root == null)
			return false;
		if(root.val == target) {
			System.out.print(root.val + " ");
			return true;
		}

		if(findPath(root.left, target) || findPath(root.right, target)) {
			System.out.print(root.val + " ");
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		TreeNode root=new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		int x=5;
		findPath(root, x);
	}
}
