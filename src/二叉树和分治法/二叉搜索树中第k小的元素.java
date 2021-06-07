package 二叉树和分治法;

public class 二叉搜索树中第k小的元素 {
    // based on quickSort
    // quickSelect
    public int kthSmallest(TreeNode root, int k) {
        int leftN = getSum(root.left);
        if (leftN + 1 == k)
            return root.val;
        else if (k <= leftN) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - leftN - 1);
        }
    }

    /////reset

    private int getSum(TreeNode root) {
        if (root == null)
            return 0;
        return getSum(root.left) + getSum(root.right) + 1;
    }
}
