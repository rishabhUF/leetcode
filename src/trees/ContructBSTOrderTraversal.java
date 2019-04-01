package trees;

import java.util.LinkedList;
import java.util.Queue;

class NodeDetails {
	TreeNode root;
	int min;
	int max;

	public NodeDetails(TreeNode root, int min, int max) {
		this.root = root;
		this.min = min;
		this.max = max;
	}
}

public class  ContructBSTOrderTraversal {

	public TreeNode constructTree(int[] arr) {
		if(arr == null) return null;
		Queue<NodeDetails> queue = new LinkedList<>();
		int i = 0;
		TreeNode root = new TreeNode(arr[i++]);
		NodeDetails nodeDetails = new NodeDetails(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		queue.add(nodeDetails);
		while(i < arr.length) {
			NodeDetails temp = queue.poll();
			if(i < arr.length && arr[i] < temp.root.val && arr[i] > temp.min)
			{
				NodeDetails nodeDetails1 = new NodeDetails(new TreeNode(arr[i++]), temp.min, temp.root.val);
				queue.offer(nodeDetails1);
				temp.root.left = nodeDetails1.root;
			}
			if(i < arr.length && arr[i] > temp.root.val && arr[i] < temp.max)
			{
				NodeDetails nodeDetails1 = new NodeDetails(new TreeNode(arr[i++]), temp.root.val, temp.max);
				queue.offer(nodeDetails1);
				temp.root.right = nodeDetails1.root;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{7, 4, 12, 3, 6, 8, 1, 5, 10};
		ContructBSTOrderTraversal contructBSTOrderTraversal = new ContructBSTOrderTraversal();
		TreeNode root = contructBSTOrderTraversal.constructTree(arr);
		System.out.print(root.right.val);
	}
}
