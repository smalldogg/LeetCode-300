package 二叉树和分治法;

/**
 * @author wangyh
 * @create 2020-07-27 14:02
 */

public class 检查平衡性 {

    class ReturnType {
        public boolean isB;
        public int height;

        public ReturnType(boolean isB, int height) {
            this.isB = isB;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return balance(root).isB;
    }

    private ReturnType balance(TreeNode node) {
        if (node == null)
            return new ReturnType(true, 0);
        ReturnType left = balance(node.left);
        ReturnType right = balance(node.right);
        if (!left.isB)
            return new ReturnType(false, -1);
        if (!right.isB)
            return new ReturnType(false, -1);
        if (Math.abs(left.height - right.height) > 1)
            return new ReturnType(false, -1);
        return new ReturnType(true, Math.max(left.height, right.height) + 1);
    }
}
