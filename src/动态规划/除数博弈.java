package 动态规划;

/**
 * @author wangyh
 * @create 2020-07-24 21:49
 */

public class 除数博弈 {
		public boolean divisorGame( int N ) {
				if( N <= 1 )
						return false;
				boolean[] dp = new boolean[N + 1];
				dp[1] = false;
				dp[2] = true;
				//这里让对手必败的那一步就是必胜
				for( int i = 3; i <= N; ++i ) {
						for( int j = 1; j < i; ++j )
								if( dp[i] = i % j == 0 && dp[i - j] == false ) {
										dp[i] = true;
										break;
								}
				}
				return dp[N];
		}
}
