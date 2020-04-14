package codingInterviewPatterns.treeDepthFirstSearch;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        if(root == null)
            return allPaths;
        findAllPaths(root, sum, new LinkedList<>(), allPaths);
        return allPaths;
    }

    public static void findAllPaths(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> allPaths) {
        if(root == null || sum - root.val < 0)
            return;
        temp.add(root.val);
        if(root.left == null && root.right == null && sum - root.val == 0) {
            allPaths.add(new ArrayList<>(temp));
        }
        findAllPaths(root.left, sum-root.val, temp, allPaths);
        findAllPaths(root.right, sum-root.val, temp, allPaths);
        temp.remove(temp.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}