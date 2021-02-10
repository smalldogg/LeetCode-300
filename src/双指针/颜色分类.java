package 双指针;

public class 颜色分类 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int l = 0;
        int r = nums.length - 1;
        int idx = 0;
        while (idx <= r) {
            if (nums[idx] == 0) {
                int temp = nums[idx];
                nums[idx] = nums[l];
                nums[l] = temp;
                l++;
                idx++;
            } else if (nums[idx] == 2) {
                int temp = nums[idx];
                nums[idx] = nums[r];
                nums[r] = temp;
                r--;
            } else {
                idx++;
            }
        }
    }
}
