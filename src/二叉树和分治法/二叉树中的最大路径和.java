package 二叉树和分治法;

/**
 * Created by wyh on 2019/5/31.
 */
public class 二叉树中的最大路径和 {
    //任意节点开始任意节点结束
    public class ReturnType {
        int maxPath, singlePath;

        public ReturnType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return help(root).maxPath;
    }

    //1.递归的定义
    private ReturnType help(TreeNode node) {
        //3.递归的出口
        if (node == null) {
            return new ReturnType(0, Integer.MIN_VALUE);
        }
        //2.递归的拆解
        ReturnType left = help(node.left);
        ReturnType right = help(node.right);

        int singlePath = Math.max(left.singlePath, right.singlePath) + node.val;
        singlePath = Math.max(0, singlePath);
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath,
                left.singlePath + right.singlePath+ node.val);
        return new ReturnType(singlePath, maxPath);
    }
}
