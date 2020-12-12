package 动态规划;

public class 数字三角形 {
		public int minimumTotal( int[][] triangle ) {
				if( triangle == null || triangle.length == 0 ) {
						return -1;
				}
				if( triangle[0] == null || triangle[0].length == 0 ) {
						return -1;
				}

				int n = triangle.length;
				int[][] dp = new int[n][n];

				for( int i = 0; i < n; i++ ) {
						dp[n - 1][i] = triangle[n - 1][i];
				}

				for( int i = n - 2; i >= 0; i-- ) {
						for( int j = 0; j < i; j++ ) {
								dp[i][j] = Math.min( dp[i + 1][j], dp[i + 1][j + 1] ) + triangle[i][j];
						}
				}
				return dp[0][0];
		}
}
