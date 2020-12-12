package 双指针;

import java.util.Arrays;

public class 两数之和2 {
    //大于给定值的数量
    public int twoSum2(int[] nums, int target) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum <= target) {
                l++;
            } else {
                res += r - l;
                r--;
            }
        }
        return res;
    }
}
