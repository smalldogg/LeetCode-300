package 数组;

/**
 * @author wangyh
 * @create 2020-11-19 17:54
 */

public class 主要元素 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int count = 1;
        int base = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (base == nums[i])
                count++;
            else if (count == 0) {
                base = nums[i];
                count = 1;
            } else
                count--;
        }
        // doubel check
        count = 0;
        for (int i = 0; i < nums.length; ++i)
            if (base == nums[i])
                count++;
        return count > nums.length / 2 ? base : -1;
    }
}
