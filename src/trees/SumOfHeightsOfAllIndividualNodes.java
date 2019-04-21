package trees;

class Sum {
    int res = 0;
}

public class SumOfHeightsOfAllIndividualNodes {

    int findSumOfHeights(TreeNode root, Sum sum) {
        if(root == null) {
            return 0;
        }
        int left = findSumOfHeights(root.left, sum);
        int right = findSumOfHeights(root.right, sum);
        int curHeight = 1+ Math.max(left, right);
        sum.res += curHeight;
        return curHeight;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        SumOfHeightsOfAllIndividualNodes sumOfHeightsOfAllIndividualNodes = new SumOfHeightsOfAllIndividualNodes();
        Sum sum = new Sum();
        sumOfHeightsOfAllIndividualNodes.findSumOfHeights(root, sum);
        System.out.print(sum.res);
    }
}
