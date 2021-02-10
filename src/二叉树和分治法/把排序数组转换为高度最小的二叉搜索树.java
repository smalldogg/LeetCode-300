package 二叉树和分治法;

/**
 * Created by wyh on 2019/6/1.
 */
public class 把排序数组转换为高度最小的二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return genereate(nums, 0, nums.length - 1);
    }

    //1.递归的定义:根据有序数组创建二叉树
    private TreeNode genereate(int[] nums, int start, int end) {
        //3.递归的出口
        if (start > end) {
            return null;
        }
        //2.递归的拆解
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = genereate(nums, start, mid - 1);
        root.right = genereate(nums, mid + 1, end);
        return root;
    }
}
