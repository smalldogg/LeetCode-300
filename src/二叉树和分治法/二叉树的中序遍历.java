package 二叉树和分治法;

import java.util.*;

/**
 * Created by wyh on 2019/5/31.
 */
public class 二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }


    public List<Integer> inordertraver(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || deque.isEmpty()) {
            while (node != null) {
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }


}
