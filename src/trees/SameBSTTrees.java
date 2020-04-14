package trees;

import java.util.HashSet;
import java.util.Set;

/*
Given two Binary Search Trees consisting of unique positive elements,
we have to check whether the two BSTs contains same set or elements or not.
 */
public class SameBSTTrees {

    private static boolean isSame(TreeNode root1, TreeNode root2) {
        /*
        1. First approach that I am thinking is create the a hash set when iterating over the tree
        (inorder traversal).
            This approach has time complexity of O( n + m ) where n is the number of nodes in root1 and m is
            number of nodes in root2. Space Complexity will be O(n + m)

         */

        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        addToHashSet(root1, set1);
        addToHashSet(root2, set2);

        return set1.equals(set2);
    }

    private static void addToHashSet(TreeNode root1, Set<Integer> set1) {
        if(root1 == null)
            return;
        addToHashSet(root1.left, set1);
        set1.add(root1.val);
        addToHashSet(root1.right, set1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left = new TreeNode(1);

        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left = new TreeNode(4);

        System.out.println(isSame(root, root2));
    }
}
