package 二分;

/**
 * Created by wyh on 2019/5/30.
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && nums[mid] >= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] <= target && nums[end] >= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    /**
     * 搜索旋转排序数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > nums[start]) {//前半部分有序
                if (nums[start] <= target && nums[mid] >= target) end = mid;
                else start = mid;
            } else {
                if (nums[mid] <= target && nums[end] >= target) start = mid;
                else end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
