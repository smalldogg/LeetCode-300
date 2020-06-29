package 数组;

/**
 * @author wangyh
 * @create 2020-02-13 16:57
 */

public class 跳数组 {
    public boolean canJumpToLast(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length, max = 0;
        for (int i = 0; i < n; ++i) {
            if (max >= n - 1) return true;
            if (i > max) return false;
            max = Math.max(max, i + nums[i]);
        }
        return false;
    }
}
