package trees;

public class LargestSubtreeSum {

    int findLargestSubtreeSum(TreeNode root) {
        if(root == null)
            return 0;

        Index sum = new Index(0);
        largestSubtreeSum(root,sum);
        return sum.index;
    }

    private int largestSubtreeSum(TreeNode root, Index sum) {
        if(root == null)
            return 0;

        int currrentSum = root.val + largestSubtreeSum(root.right,sum) + largestSubtreeSum(root.left, sum);
        sum.index = Math.max(currrentSum, sum.index);
        return currrentSum;
    }
}
