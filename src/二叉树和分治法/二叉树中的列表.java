package 二叉树和分治法;

/**
 * @author wangyh
 * @create 2020-07-27 13:38
 */

public class 二叉树中的列表 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        return dfs(head, root) || isSubPath(head, root.right) || isSubPath(head, root.left);
    }

    private boolean dfs(ListNode h, TreeNode node) {
        if (h == null)
            return true;
        if (node == null)
            return false;
        if (node.val != h.val)
            return false;
        return dfs(h.next, node.right) || dfs(h.next, node.left);
    }
}
