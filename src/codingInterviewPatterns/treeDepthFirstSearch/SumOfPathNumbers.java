package codingInterviewPatterns.treeDepthFirstSearch;
import java.util.*;

class SumOfPathNumbers {
    static int totalSum = 0;
    public static int findSumOfPathNumbers(TreeNode root) {
        // TODO: Write your code here
        if(root == null)
            return totalSum;
        findPath(root, new LinkedList<>());
        return totalSum;
    }

    private static void findPath(TreeNode root, LinkedList<Integer> temp) {
        if(root == null)
            return;
        temp.add(root.val);
        if(root.left == null && root.right == null) {
            int currentNumber = 0;
            for(int i=0; i < temp.size(); i++) {
                currentNumber =  (currentNumber * 10 + temp.get(i));
            }
            totalSum+= currentNumber;
        } else {
            findPath(root.left, temp);
            findPath(root.right, temp);
        }
        temp.remove(temp.size()-1);
        "String".contains("Heloo");
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}