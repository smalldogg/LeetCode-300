package 双指针;

public class 两数和2输入已排序的数组 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
