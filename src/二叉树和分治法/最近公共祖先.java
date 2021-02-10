package 二叉树和分治法;

/**
 * Created by wyh on 2019/5/31.
 */
public class 最近公共祖先 {
    //1.递归的定义:找到两个节点的公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }

        return null;
    }
}
