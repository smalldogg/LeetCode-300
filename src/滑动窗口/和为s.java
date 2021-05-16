package 滑动窗口;

import java.util.concurrent.CountDownLatch;

public class 和为s {
    public boolean finds(int[] nums, int s) {
        if (nums == null || nums.length == 0) return false;
        int max = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            cur += nums[i];
            max = Math.max(cur, max);
            cur = cur < 0 ? 0 : cur;
        }
        return cur == s;
    }
}