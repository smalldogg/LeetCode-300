package 二叉树和分治法;

/**
 * Created by wyh on 2019/5/31.
 */
public class 验证二叉查找树 {

    public class ReturnType {
        public int max;
        public int min;
        public boolean isB;

        public ReturnType(int max, int min, boolean isB) {
            this.max = max;
            this.min = min;
            this.isB = isB;
        }
    }


    public boolean isValidBST(TreeNode root) {
        return help(root).isB;
    }

    //1.递归的定义 ： 验证二叉查找树
    public ReturnType help(TreeNode node) {
        //3.递归的出口
        if (node == null) {
            return new ReturnType(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        //2.递归的拆解
        ReturnType left = help(node.left);
        ReturnType right = help(node.right);
        if (!left.isB) {
            return new ReturnType(-1, -1, false);
        }
        if (!right.isB) {
            return new ReturnType(-1, -1, false);
        }
        if (node.left != null && left.max >= node.val ||
                node.right != null && right.min <= node.val) {
            return new ReturnType(-1, -1, false);
        }
        return new ReturnType(Math.max(node.val, right.max),
                Math.min(node.val, left.min), true);
    }

}
