package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LevelOrderSpiralOrder {

   static List<Integer> levelOrderSpiralOder(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       if(root == null) {
           return result;
       }
       Stack<TreeNode> s1 = new Stack<>();
       Stack<TreeNode> s2 = new Stack<>();
       s1.push(root);
       while(!s1.isEmpty() || !s2.isEmpty()) {
           while(!s1.isEmpty()) {
               TreeNode temp = s1.pop();
               result.add(temp.val);
               if(temp.right!=null)
                 s2.add(temp.right);
               if(temp.left!=null)
               s2.add(temp.left);
           }
           while(!s2.isEmpty()) {
               TreeNode temp = s2.pop();
               result.add(temp.val);
               if (temp.left != null)
                   s1.add(temp.left);
               if (temp.left != null)
                   s1.add(temp.right);
           }
       }
       return result;
   }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(6);

        List<Integer> res = levelOrderSpiralOder(root);
        for(int i : res) {
            System.out.println("hello " + i);
        }
    }
}
