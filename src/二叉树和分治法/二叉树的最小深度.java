package 二叉树和分治法;

/**
 * Created by wyh on 2019/5/31.
 */
public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    private int getMin(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        if (node.left == null && node.right == null) return 1;
        return Math.min(getMin(node.left), getMin(node.right)) + 1;
    }
}
