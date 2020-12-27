package 动态规划;

public class 跳跃游戏 {
		public boolean canJump( int[] A ) {
				int n = A.length;
				boolean[] dp = new boolean[n];
				dp[0] = true;

				for( int i = 1; i < n; i++ ) {
						for( int j = 0; j < i; j++ ) {
								if( dp[j] && A[j] + j >= i ) {
										dp[i] = true;
								}
						}
				}
				return dp[n - 1];
		}
}
