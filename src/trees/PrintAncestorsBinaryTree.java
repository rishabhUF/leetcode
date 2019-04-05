package trees;

public class PrintAncestorsBinaryTree {

	boolean printAncestors(TreeNode root, int target) {
		if(root == null)
			return false;

		if(root.val == target)
			return true;

		if(printAncestors(root.left,target) || printAncestors(root.right,target))
			System.out.println(root.val);

		return false;
	}
}
