package 数组;


/**
 * @author wangyh
 * @create 2021-02-28 11:30
 */

public class 单调数列 {
    public boolean isMonotonic(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        boolean result1 = true, reuslt2 = true;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                result1 = false;
                break;
            }
        }
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                reuslt2 = false;
                break;
            }
        }
        return result1 || reuslt2;
    }
}
