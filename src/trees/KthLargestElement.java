package trees;

public class KthLargestElement {

	Index index = new Index();
	int findKthLargest(TreeNode root, int k) {
		if(root == null) return -1;
		int[] res = new int[]{-1};
		index.index = k;
		findKthLargestHelper(root,index,res);
		return res[0];
	}

	private void findKthLargestHelper(TreeNode root, Index k, int[] res) {
		if(root == null) return;
		findKthLargestHelper(root.right,k,res);
		k.index--;
		if(k.index-1 == 0) {
			res[0] = res[0] == -1 ? root.val : res[0];
			return;
		}
		findKthLargestHelper(root.left,k,res);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		KthLargestElement kthLargestElement = new KthLargestElement();
		System.out.print(kthLargestElement.findKthLargest(root,2));
	}
}
