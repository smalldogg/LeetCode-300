package 双指针;

public class 滑动窗口内数的和 {


    public int[] winSum(int[] nums, int k) {
        if (nums == null) {
            return new int[0];
        }
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        res[0] = sum;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] - nums[i - 1] + nums[i + k - 1];
        }
        return res;
    }
}
