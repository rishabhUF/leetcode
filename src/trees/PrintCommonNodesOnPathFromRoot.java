package trees;

public class PrintCommonNodesOnPathFromRoot {

	static boolean printCommonNodesOnPathFromRoot(TreeNode root, int n1, int n2) {

		if(root == null)
			return false;
		TreeNode temp = root;
		TreeNode lca = findLCA(root, n1, n2);
		System.out.println(lca.val);
		return printCommonNodesOnPathFromRootHelper(root, lca.val);
	}

	static private boolean printCommonNodesOnPathFromRootHelper(TreeNode root, int target) {
		if(root == null)
			return false;
		if(root.val == target) {
			System.out.print(root.val+ " ");
			return true;
		}
		if(printCommonNodesOnPathFromRootHelper(root.left,target) || printCommonNodesOnPathFromRootHelper(root.right, target)) {
			System.out.print(root.val + " ");
			return true;
		}
		return false;
	}

	static private TreeNode findLCA(TreeNode root, int n1, int n2) {
		if(root == null)
			return null;
		if(root.val == n1 || root.val == n2) {
			return root;
		}
		TreeNode left = findLCA(root.left, n1, n2);
		TreeNode right = findLCA(root.right, n1, n2);
		if(left!= null && right!= null)
			return root;
		return left!= null ? left : findLCA(root.right, n1, n2);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);

		if (printCommonNodesOnPathFromRoot(root, 9, 7) == false)
			System.out.println("No Common nodes");
	}
}
