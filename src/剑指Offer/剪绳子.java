package 剑指Offer;

/**
 * @author wangyh
 * @create 2020-02-13 10:40
 */

public class 剪绳子 {
		public int cuttingRope( int n ) {
				//最后一刀可能在哪
				int[] dp = new int[n + 1];
				dp[1] = 1;
				for( int i = 2; i <= n; ++i ) {
						for( int j = 1; j < i; ++j ) {
								dp[i] = Math.max( dp[i], j * ( i - j ) );
								dp[i] = Math.max( dp[i], dp[j] * ( i - j ) );
						}
				}
				return dp[n];
		}
}
