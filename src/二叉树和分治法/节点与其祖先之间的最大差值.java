package 二叉树和分治法;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangyh
 * @create 2020-07-28 19:53
 */

public class 节点与其祖先之间的最大差值 {
    int result = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, 0, 0);
        return result;
    }

    private void dfs(TreeNode node, int max, int min) {
        if (node == null)
            return;
        if (node.val < min)
            min = node.val;
        if (node.val > max)
            max = node.val;
        if (node.left == null && node.right == null)
            result = Math.max(result, max - min);
        dfs(node.left, max, min);
        dfs(node.right, max, min);
    }
}
