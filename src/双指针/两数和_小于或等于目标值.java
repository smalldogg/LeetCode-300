package 双指针;

import java.util.Arrays;

public class 两数和_小于或等于目标值 {
    public int twoSum5(int[] nums, int target) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum <= target) {
                res += r - l;
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
