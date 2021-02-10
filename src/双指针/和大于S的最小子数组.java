package 双指针;

/**
 * @author wangyh
 * @create 2020-02-07 17:22
 */

public class 和大于S的最小子数组 {
    //窗口问题
    public int minimumSize(int[] nums, int s) {
        int max = Integer.MAX_VALUE;
        int sum = 0;
        for (int l = 0, r = 0; r < nums.length; ++r) {
            sum += nums[r];
            while (sum >= s) {
                max = Math.min(max, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return max;
    }
}
