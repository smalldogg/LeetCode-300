package 二叉树和分治法;

import java.util.Stack;

/**
 * Created by wyh on 2019/5/31.
 */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    TreeNode next = null;


    private void AddNodeToStack(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }


    // @param root: The root of binary tree.
    public BSTIterator(TreeNode root) {

        next = root;
    }

    public boolean hasNext() {
        if (next != null) {
            AddNodeToStack(next);
            next = null;
        }
        return !stack.isEmpty();
    }

    //@return: return next node
    public TreeNode next() {
        if (!hasNext()) {
            return null;
        }
        TreeNode cur = stack.pop();
        next = cur.right;
        return cur;
    }
}
