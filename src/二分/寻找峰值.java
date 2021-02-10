package 二分;

/**
 * Created by wyh on 2019/5/30.
 */
public class 寻找峰值 {
    public int findPeak(int[] nums) {
        int start = 1, end = nums.length - 2;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return end;
        }
        return start;
    }
}
