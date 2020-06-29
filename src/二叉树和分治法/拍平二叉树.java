package 二叉树和分治法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyh
 * @create 2020-02-13 15:05
 */

public class 拍平二叉树 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        TreeNode cur = root;
        for (int i = 1; i < list.size(); ++i) {
            cur.right = list.get(i);
            cur.left = null;
            cur = cur.right;
        }
    }

    private void preorder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }


    public void flattenReversePreorder(TreeNode root) {
        if (root == null) return;
        flattenReversePreorder(root.left);
        flattenReversePreorder(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) root = root.right;
        root.right = temp;
    }
}
