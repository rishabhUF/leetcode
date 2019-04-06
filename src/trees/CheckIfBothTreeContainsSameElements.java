package trees;

import java.util.HashSet;
import java.util.Set;

public class CheckIfBothTreeContainsSameElements {

	public static boolean checkIfBothTressContainsSameElements(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) return true;
		if(root1 == null || root2 == null) return false;

		Set<Integer> set1 = new HashSet<>();
		inOrderHelper(root1,set1);
		Set<Integer> set2 = new HashSet<>();
		inOrderHelper(root2,set2);
		if(set1.size() != set2.size()) {
			return false;
		}
		for(int k : set1) {

			if (!set2.contains(k)) {
				return false;
			}
		}
		return true;
	}

	private static void inOrderHelper(TreeNode root, Set<Integer> set1) {
		if(root == null) return;
		inOrderHelper(root.left, set1);
		set1.add(root.val);
		inOrderHelper(root.right,set1);
	}

	public static void main(String[] args) {
		TreeNode root = null;
//		root = TreeNode.insert(root, 15);
//		root = TreeNode.insert(root,10);
//		root = TreeNode.insert(root,20);
//		root = TreeNode.insert(root,5);
//		root = TreeNode.insert(root,12);
//		root = TreeNode.insert(root,25);
//
		TreeNode root2 = null;
//		root2 = TreeNode.insert(root2,15);
//		root2 = TreeNode.insert(root2,12);
//		root2 = TreeNode.insert(root2,20);
//		root2 = TreeNode.insert(root2,5);
//		root2 = TreeNode.insert(root2,10);
//		root2 = TreeNode.insert(root2,45);

		if(checkIfBothTressContainsSameElements(root,root2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
