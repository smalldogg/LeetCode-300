package 二叉树和分治法;

/**
 * Created by wyh on 2019/5/31.
 */
public class 二叉树的最大路径和II {
    //根节点出发到任意节点
    //1.递归的定义：二叉树的最大路径和
    public int maxPathSum2(TreeNode root) {
        //3.递归的出口
        if (root == null) {
            return 0;
        }
        //2递归的定义
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return root.val + Math.max(0,Math.max(left, right));
    }
}
