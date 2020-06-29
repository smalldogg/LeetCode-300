package 二叉树和分治法;

/**
 * Created by wyh on 2019/6/1.
 */
public class 二叉树的最长连续子序列II {

    public class ReturnType {
        int maxLength;
        int up;
        int down;

        public ReturnType(int maxLength, int up, int down) {
            this.maxLength = maxLength;
            this.up = up;
            this.down = down;
        }
    }

    public int longestConsecutive2(TreeNode root) {
        return process(root).maxLength;
    }

    private ReturnType process(TreeNode node) {
        if (node == null) {
            return new ReturnType(0, 0, 0);
        }

        ReturnType left = process(node.left);
        ReturnType right = process(node.right);

        int up = 0, down = 0;
        if (node.left != null && node.left.val + 1 == node.val) {
            down = Math.max(left.down + 1, down);
        }
        if (node.left != null && node.left.val - 1 == node.val) {
            up = Math.max(left.up + 1, up);
        }
        if (node.right != null && node.right.val + 1 == node.val) {
            down = Math.max(right.down + 1, down);
        }
        if (node.right != null && node.right.val - 1 == node.val) {
            up = Math.max(right.up + 1, up);
        }
        int len = up + down + 1;
        len = Math.max(len, Math.max(left.maxLength, right.maxLength));
        return new ReturnType(len, up, down);
    }
}
