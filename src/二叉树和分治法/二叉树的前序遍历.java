package 二叉树和分治法;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wyh on 2019/5/31.
 */
public class 二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    //递归
    public ArrayList<Integer> preorderTraversal2(TreeNode root) {
        // write your code here
        ArrayList<Integer> preorder = new ArrayList();
        preorderTraversal(root, preorder);
        return preorder;
    }

    public static void preorderTraversal(TreeNode root, ArrayList<Integer> preorder) {
        if (null == root) {
            return;
        }
        preorder.add(root.val);
        preorderTraversal(root.left, preorder);
        preorderTraversal(root.right, preorder);
    }
}
