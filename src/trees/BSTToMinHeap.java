package trees;

import java.util.LinkedList;
import java.util.List;

public class BSTToMinHeap {

	void convertBSTToLL(TreeNode root, List<Integer> result) {
		if(root == null) return;
		convertBSTToLL(root.left, result);
		result.add(root.val);
		convertBSTToLL(root.right, result);
	}

	public static void main(String[] args) {
		BSTToMinHeap min = new BSTToMinHeap();
		TreeNode root = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left = new TreeNode(1);
		List<Integer> res = new LinkedList<>();
		min.convertBSTToLL(root, res);

	}
}
