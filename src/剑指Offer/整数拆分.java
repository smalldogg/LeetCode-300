package 剑指Offer;

/**
 * @author wangyh
 * @create 2020-02-13 10:53
 */

public class 整数拆分 {
		public int integerBreak( int n ) {
				int[] dp = new int[n + 1];
				dp[1] = 1;
				for( int i = 2; i <= n; ++i ) {
						for( int j = 1; j < i; ++j ) {
								dp[i] = Math.max( dp[i], dp[j] * ( i - j ) );
								dp[i] = Math.max( dp[i], j * ( i - j ) ); // 拆成两个数
						}
				}
				return dp[n];
		}
}
