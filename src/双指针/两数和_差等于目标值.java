package 双指针;

import java.util.HashMap;
import java.util.Map;

public class 两数和_差等于目标值 {


    public int[] twoSum7(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == target || nums[j] - nums[i] == -target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                }
            }
        }
        return res;
    }

    public int[] twoSum7_2(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - target)) {
                res[0] = map.get(nums[i] - target) + 1;
                res[1] = i + 1;
            }
            if (map.containsKey(nums[i] + target)) {
                res[0] = map.get(target + nums[i]) + 1;
                res[1] = i + 1;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
