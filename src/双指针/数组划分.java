package 双指针;

public class 数组划分 {
    //返回大于等于k的第一个位置
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[l] < k) {
                l++;
            }
            while (l < r && nums[r] >= k) {
                r--;
            }
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
        return l;
    }
}
