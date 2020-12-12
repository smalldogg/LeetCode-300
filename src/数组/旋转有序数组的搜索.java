package 数组;

/**
 * @author wangyh
 * @create 2020-02-24 14:13
 */

public class 旋转有序数组的搜索 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[l]) { //在哪一边
                if (nums[l] <= target && nums[mid] >= target) r = mid;
                else l = mid;
            } else {
                if (nums[mid] <= target && nums[r] >= target) l = mid;
                else r = mid;
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        else return -1;
    }
}
