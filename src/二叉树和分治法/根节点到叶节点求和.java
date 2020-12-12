package 二叉树和分治法;

/**
 * Created by wyh on 2019/5/31.
 */
public class 根节点到叶节点求和 {
    public int sumNumbers(TreeNode root) {
        return help(root, 0);
    }

    //1.递归的定义：根节点到叶子节点求和
    private int help(TreeNode node, int prev) {
        if (node == null) {
            return 0;
        }

        int sum = prev * 10 + node.val;

        if (node.left == null && node.right == null) {
            return sum;
        }

        int left = help(node.left, sum);
        int right = help(node.right, sum);
        return left + right;
    }
}
