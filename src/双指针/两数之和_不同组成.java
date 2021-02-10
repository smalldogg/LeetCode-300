package 双指针;

import java.util.Arrays;

public class 两数之和_不同组成 {
    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, res = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                res++;
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1])
                    l++;
                while (l < r && nums[r] == nums[r + 1])
                    r--;
            } else if (sum > target)
                r--;
            else
                l++;
        }
        return res;
    }
}
