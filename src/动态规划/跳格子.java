package 动态规划;

/**
 * @author wangyh
 * @create 2020-07-17 9:42
 */

public class 跳格子 {

		public static int minStep( int[] nums ) {
				if( nums == null || nums.length == 0 )
						return 0;
				int n = nums.length;
				int[] dp = new int[n];
				int sum = nums[0];
				dp[0] = sum;
				for( int i = 1; i < n; i++ ) {
						sum += nums[i];
						dp[i] = sum;
				}
				for( int i = 1; i < n; ++i ) {
						for( int j = 0; j < 5 && i - j >= 0; j++ )
								dp[i] = Math.min( nums[i] + dp[i - j], dp[i] );
				}
				return dp[n - 1];
		}
}
