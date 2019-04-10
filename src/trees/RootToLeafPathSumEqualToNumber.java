package trees;

public class RootToLeafPathSumEqualToNumber {

    static boolean pathFinder(TreeNode root, int target) {
        if(root == null && target!= 0)
            return false;
        int currentValue = target - root.val;
        if(root.left == null && root.right == null && currentValue == 0) {
            return true;
        }
        boolean left = pathFinder(root.left, currentValue);
        boolean right = pathFinder(root.right, currentValue);
        return left || right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        System.out.print(pathFinder(root, 50));
    }
}
