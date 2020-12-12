package 数组;

import java.util.ArrayList;
import java.util.List;

public class 连续子数组求和 {
    //子数组的和最大
    public List<Integer> continuousSubarraySum(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        res.add(0);
        res.add(0);
        int sum = 0;
        int max =Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = nums[i];
                start = end = i;
            } else {
                sum += nums[i];
                end = i;
            }
            if (sum > max) {
                max = sum;
                res.set(0, start);
                res.set(1, end);
            }
        }
        return res;
    }
}
