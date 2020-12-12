package 数组;

/**
 * @author wangyh
 * @create 2020-02-13 16:56
 */

public class 旋转数组 {
    private void reverse(int[] nums, int i, int j) {
        for (; i < j; ++i, --j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    // Time: O(n), Space: O(1)
    public void rotateBySwap(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return;
        int n = nums.length, m = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, m - 1);
        reverse(nums, m, n - 1);
    }
}
