package 二叉树和分治法;

/**
 * Created by wyh on 2019/6/1.
 */
public class 左叶子的和 {
    //1.递归的定义：左叶子节点的和
    public int sumOfLeftLeaves(TreeNode root) {
        //3.递归的出口
        if (root == null) {
            return 0;
        }

        //2.递归的拆解
        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }

        return sum;
    }
}
