package 二叉树和分治法;

/**
 * @author wangyh
 * @create 2020-02-24 11:57
 */

public class 二叉搜索树中删除节点 {

    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val < val) {
            root.right = deleteNode(root.right, val);
        } else if (root.val > val) {
            root.left = deleteNode(root.left, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                //找到右子树的最小值
                TreeNode rightMin = root.right;
                while (rightMin.left != null) rightMin = rightMin.left;
                rightMin.left = root.left;
                root = root.right;
            }
        }
        return root;
    }
}
