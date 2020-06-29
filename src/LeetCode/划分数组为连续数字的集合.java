package LeetCode;

import java.util.Arrays;

/**
 * @author wangyh
 * @create 2019-12-22 10:38
 */

public class 划分数组为连续数字的集合 {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length < k) {
            return false;
        }
        Arrays.sort(nums);
        boolean[] v = new boolean[nums.length];
        int pre;
        int cnt;
        for (int i = 0; i < nums.length; ++i) {
            if (v[i]) continue;
            pre = nums[i];
            v[i] = true;
            cnt = 1;
            for (int j = 0; j < nums.length - i && cnt < k; ++j) {
                int l = i + j;
                if (v[l]) continue;
                if (nums[l] - pre > 1) return false;
                else if (nums[l] - pre == 1) {
                    cnt++;
                    pre = nums[l];
                    v[l] = true;
                }
            }
            if (cnt < k) return false;
        }
        return true;
    }
}
