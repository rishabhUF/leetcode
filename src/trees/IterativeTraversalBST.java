package trees;

public class IterativeTraversalBST {

	static boolean iterativeSearch( TreeNode root, int key)
	{
		// Traverse untill root reaches to dead end
		while (root != null)
		{
			// pass right subtree as new tree
			if (key > root.val)
				root = root.right;

				// pass left subtree as new tree
			else if (key < root.val)
				root = root.left;
			else
				return true;// if the key is found return 1
		}
		return false;
	}
}
