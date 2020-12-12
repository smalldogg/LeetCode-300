package 动态规划;

import java.util.List;

/**
 * @author wangyh
 * @create 2020-07-14 9:36
 */

public class 三角形最小路径和 {
		public int minimumTotal( List<List<Integer>> triangle ) {
				int n = triangle.size( );
				int[][] dp = new int[n + 1][n + 1];
				for( int i = n - 1; i >= 0; --i ) {
						for( int j = 0; j <= i; ++j ) {
								dp[i][j] = Math.min( dp[i + 1][j], dp[i + 1][j + 1] ) + triangle.get( i ).get( j );
						}
				}
				return dp[0][0];
		}
}
