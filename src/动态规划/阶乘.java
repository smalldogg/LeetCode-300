package 动态规划;

/**
 * @author wangyh
 * @create 2020-05-19 11:13
 */

public class 阶乘 {

		public static void main( String[] args ) {
				int n = getN2( 4 );
				System.out.println( n );
		}

		public static int getN( int n ) {
				if( n <= 0 )
						return 0;
				if( n == 1 )
						return 1;
				return n * getN( n - 1 );
		}


		public static int getN2( int n ) {
				if( n <= 0 )
						return 0;
				int[] dp = new int[n + 1];
				dp[0] = 0;
				dp[1] = 1;
				for( int i = 2; i <= n; ++i ) {
						for( int j = 1; j < i; ++j ) {
								dp[i] = dp[j] * i;
						}
				}
				return dp[n];
		}

}
