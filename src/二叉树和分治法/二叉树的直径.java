package 二叉树和分治法;

/**
 * Created by wyh on 2019/6/1.
 */
public class 二叉树的直径 {
    //一个节点直径是0
    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        nodes(root);
        return result;
    }
    
    private int nodes(TreeNode root) {
        //3.递归的出口
        if (root == null) {
            return 0;
        }
        //2.递归的拆解
        int left = nodes(root.left);
        int right = nodes(root.right);
        result = Math.max(result, left + right);

        return Math.max(left, right) + 1;
    }
}
