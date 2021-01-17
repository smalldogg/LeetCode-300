package 数组;

import java.util.Arrays;

/**
 * @author wangyh
 * @create 2021-01-15 18:39
 */

public class 跳跃游戏VI {
		public int maxResult(int[] nums, int k) {
				int len = nums.length;
				int[] dp = new int[len];
				Arrays.fill(dp, Integer.MIN_VALUE);
				dp[0] = nums[0];
				for (int i = 1; i < nums.length; ++i) {
						for (int j = i - 1; j >= 0 && j >= i - k; --j) {
								dp[i] = Math.max(dp[i], dp[j]);
						}
						dp[i] += nums[i];
				}
				return dp[len - 1];
		}
}
