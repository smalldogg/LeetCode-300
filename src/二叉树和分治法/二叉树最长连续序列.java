package 二叉树和分治法;

/**
 * Created by wyh on 2019/6/1.
 */
public class 二叉树最长连续序列 {

    private int longest = 0;

    public int longestConsecutive(TreeNode root) {
        process(root);
        return longest;
    }

    private int process(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = process(node.left);
        int right = process(node.right);
        int len = 1;
        if (node.left != null && node.val + 1 == node.left.val) {
            len = Math.max(left + 1, len);
        }
        if (node.right != null && node.val + 1 == node.right.val) {
            len = Math.max(right + 1, len);
        }
        if (len > longest) {
            longest = len;
        }
        return len;
    }

}
