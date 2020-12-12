package 二叉树和分治法;

/**
 * @author wangyh
 * @create 2020-02-13 15:16
 */

public class 另一个树的子树 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return isSame(s, t)
                || isSubtree(s.right, t)
                || isSubtree(s.left, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val
                && isSame(s.left, t.left)
                && isSame(s.right, t.right);
    }
}
