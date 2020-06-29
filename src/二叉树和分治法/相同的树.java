package 二叉树和分治法;

/**
 * @author wangyh
 * @create 2020-05-27 20:34
 */

public class 相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) return
                q.val == p.val &&
                        isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return p == null && q == null;
    }
}
