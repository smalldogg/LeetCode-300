package 二分;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wyh on 2019/5/30.
 */
public class 统计比给定整数小的数的个数 {
    public List<Integer> countOfSmallerNumber(int[] nums, int[] queries) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int x : queries) {
            result.add(getFirstMore(nums, x));
        }
        return result;
    }

    private int getFirstMore(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] >= target) {
            return start;
        }
        if (nums[end] >= target) {
            return end;
        }
        return 0;
    }
}
