package 滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangyh
 * @create 2021-01-15 18:22
 */

public class 删除子数组的最大得分 {
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0;
        int sum = 0;
        int l = 0, r = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            while (set.contains(nums[r])) {
                sum -= nums[l];
                set.remove(nums[l]);
                l++;
            }
            set.add(nums[r]);
            sum += nums[r];
            r++;
            res = Math.max(sum, res);
        }
        return res;
    }
}
