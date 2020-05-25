package codingInterviewPatterns.treeDepthFirstSearch;

import java.util.*;

class CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        if(root == null)
            return 0;

        return findPaths(root, S, new ArrayList<>());
    }

    public static int findPaths(TreeNode root, int S, List<Integer> currentPath) {
        if(root == null)
            return 0;
        int totalCurrentPath = 0, currentSum = 0;
        currentPath.add(root.val);
        ListIterator<Integer> currentPathIterator = currentPath.listIterator(0);
        while(currentPathIterator.hasNext()) {
            if(currentSum == S) {
                totalCurrentPath++;
            }


        }
        return -1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}