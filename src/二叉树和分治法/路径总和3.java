package 二叉树和分治法;

/**
 * @author wangyh
 * @create 2020-07-30 20:43
 */

public class 路径总和3 {
    int result = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return result;
    }

    private void dfs(TreeNode node, int curSum) {
        if (node == null) return;
        curSum -= node.val;
        if (curSum == 0) result++;
        dfs(node.left, curSum);
        dfs(node.right, curSum);
    }
}
