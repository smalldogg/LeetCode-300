package 动态规划;

import java.util.Arrays;

public class 最长上升子序列 {
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
