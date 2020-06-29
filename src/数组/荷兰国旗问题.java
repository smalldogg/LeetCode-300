package 数组;

/**
 * @author wangyh
 * @create 2020-02-24 14:51
 */

public class 荷兰国旗问题 {
    public void sortThreeColorsSwap(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) swap(nums, left++, mid++);
            else if (nums[mid] == 1) ++mid;
            else swap(nums, mid, right--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
