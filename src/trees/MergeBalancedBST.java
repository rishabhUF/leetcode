package trees;

import java.util.ArrayList;
import java.util.List;

public class MergeBalancedBST {

	TreeNode mergeBalancedBST(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) {
			return null;
		}
		if(root1 == null) return root2;
		if(root2 == null) return root1;
		// Do inorder Traversal of the trees and store the arr
		int[] arr1 = inorderTraversal(root1);
		int[] arr2 = inorderTraversal(root2);
		// Merge the two stored array
		int[] arr3 = mergeSortedArray(arr1, arr2);
		// Convert sorted array to Balanced BST
		TreeNode result = mergeBalancedBSTHelper(arr3);
		return result;
	}

	private int[] mergeSortedArray(int[] arr1, int[] arr2) {
		if(arr1 == null && arr2 == null) return null;
		if(arr1 == null) return arr2;
		if(arr2 == null) return arr1;
		int[] result = new int[arr1.length + arr2.length];
		int k = 0, i= 0, j= 0;
		while(i<arr1.length || j<arr2.length) {
			if(i < arr1.length && j < arr2.length) {
				result[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
			} else if(i < arr1.length)
				result[k++] = arr1[i++];
			else
				result[k++] = arr2[j++];
		}
		return result;
	}

	private TreeNode mergeBalancedBSTHelper(int[] arr3) {
		if(arr3 == null) return null;
		TreeNode result = mergeBalancedBSTHelp(arr3, 0, arr3.length);
		return result;
	}

	private TreeNode mergeBalancedBSTHelp(int[] arr3, int left, int right) {
		if(arr3 == null) return null;
		if(left > right) return null;
		int mid = left + (right-left)/2;
		TreeNode root = new TreeNode(arr3[mid]);
		root.left = mergeBalancedBSTHelp(arr3, left, mid-1);
		root.right = mergeBalancedBSTHelp(arr3, mid+1, right);
		return root;
	}

	private int[] inorderTraversal(TreeNode root) {
		if(root == null) return null;
		List<Integer> temp = new ArrayList<>();
		inorderHelper(root,temp);
		int[] result = temp.stream().mapToInt(i->i).toArray();
		return result;
	}

	private void inorderHelper(TreeNode root, List<Integer> temp) {
		if(root == null)
			return;
		inorderHelper(root.left, temp);
		temp.add(root.val);
		inorderHelper(root.right, temp);
	}

	public static void main(String[] args) {

	}
}
