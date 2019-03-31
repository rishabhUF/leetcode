package trees;

public class kthSmallestElementinBST {

	public int getKthSmallest(TreeNode root, int k) {
		if(root == null || k < 0) return -1;
		int[] res = new int[1];
		Index index = new Index();
		index.index = k;
		helper(root, index, res);
		return res[0];
	}

	private void helper(TreeNode root, Index index, int[] res) {
		if(root == null) return;

		helper(root.left,index,res);
		index.index--;
		if(index.index == 0) {
			res[0] = root.val;
		}

		helper(root.right,index,res);
	}
	// This method helps to find the kth smallest element in o(h) where
	// h is the height of the tree.
	public int getKthSmallest2(TreeNode root, int k) {
		if(root == null || k < 0) return -1;


	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		kthSmallestElementinBST kthSmallestElementinBST = new kthSmallestElementinBST();
		System.out.print(kthSmallestElementinBST.getKthSmallest(root,3));
	}
}
