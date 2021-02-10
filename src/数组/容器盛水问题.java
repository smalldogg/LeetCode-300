package 数组;

/**
 * @author wangyh
 * @create 2020-02-28 15:27
 */

public class 容器盛水问题 {
    public int trap(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0;
        for (int i = 1; i < nums.length - 1; ++i) {
            int leftMax = 0, rightMax = 0;
            for (int l = 0; l < i; l++)
                leftMax = Math.max(leftMax, nums[l]);
            for (int r = i + 1; r < nums.length; ++r)
                rightMax = Math.max(rightMax, nums[r]);
            res += Math.max(Math.min(rightMax, leftMax) - nums[i], 0);
        }
        return res;
    }

    public int trap2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0;
        int leftMax = nums[0];
        int rightMax = nums[nums.length - 1];
        int L = 1, R = nums.length - 2;
        while (L <= R) {
            if (leftMax <= rightMax) {
                res += Math.max(0, leftMax - nums[L]);
                leftMax = Math.max(leftMax, nums[L]);
                L++;
            } else {
                res += Math.max(0, rightMax - nums[R]);
                rightMax = Math.max(rightMax, nums[R]);
                R--;
            }
        }
        return res;
    }
}
