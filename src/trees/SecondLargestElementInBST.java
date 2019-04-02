package trees;

public class SecondLargestElementInBST {

	int findSecondLargestElemt(TreeNode root) {
		Index i = new Index(2);
		if(root == null) return -1;
		int[] res = new int[1];
		helper(root,i,res);
		return res[0];
	}

	private void helper(TreeNode root, Index i, int[] res) {
		if(root == null) return;
		helper(root.right,i,res);
		i.index--;
		if(i.index == 0)
			res[0] = root.val;
		helper(root.left,i,res);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		SecondLargestElementInBST secondLargestElementInBST = new SecondLargestElementInBST();
		System.out.print(secondLargestElementInBST.findSecondLargestElemt(root));
	}
}
