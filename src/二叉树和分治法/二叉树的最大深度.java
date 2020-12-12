package 二叉树和分治法;

/**
 * Created by wyh on 2019/5/31.
 */
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root==null) return 0;
        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);
        return Math.max(leftH,rightH)+1;
    }

    private int depth;
    public int maxDepth2(TreeNode root) {
        helper(root,1);
        return depth;
    }

    private void helper(TreeNode node, int curDepth){
        if (node == null) {
            return;
        }
        if (curDepth > depth) {
            depth = curDepth;
        }
        helper(node.left,curDepth + 1);
        helper(node.right,curDepth + 1);
    }
}
