package 二叉树和分治法;

public class 合并两棵二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //结束条件
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null && t2 != null) {
            return t2;
        }
        if (t1 != null && t2 == null) {
            return t1;
        }
        //应该返回什么
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
