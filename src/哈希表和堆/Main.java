package 哈希表和堆;


import java.util.*;

/**
 * @author wangyh
 * @create 2020-03-06 21:16
 */
class Env {
		public int len;
		public int width;

		public Env( int len, int width ) {
				this.len = len;
				this.width = width;
		}
}


public class Main {


		public static void main2( String[] args ) {
				Scanner sc = new Scanner( System.in );
				int n1 = sc.nextInt( );
				int target = sc.nextInt( );
				int[] bag = new int[n1];
				int[] values = new int[n1];
				int max = getMax( bag, values, target );
				System.out.println( max );
		}


		public static int getMax( int[] nums1, int[] values, int target ) {
				int n = nums1.length;
				int[][] dp = new int[n + 1][target + 1];
				int res = 0;
				dp[0][0] = 0;
				for( int i = 1; i <= target; ++i )
						dp[0][i] = -1;
				for( int i = 1; i <= n; ++i ) {
						for( int j = 1; j <= target; ++j ) {
								dp[i][j] = dp[i - 1][j];
								if( j >= nums1[i - 1] && dp[i - 1][j - nums1[i - 1]] != -1 ) {
										dp[i][j] = Math.max( dp[i - 1][j - nums1[i - 1]] + values[i - 1], dp[i][j] );
										res = Math.max( res, dp[i][j] );
								}
						}
				}
				return res;
		}


		public static void main1( String[] args ) {
				Scanner scanner = new Scanner( System.in );
				int n = scanner.nextInt( );
				int[][] envs = new int[n][2];
				for( int i = 0; i < n; ++i ) {
						int len = scanner.nextInt( );
						int width = scanner.nextInt( );
						envs[i][0] = len;
						envs[i][1] = width;
				}
				int res = maxEnvelopes( envs );
				System.out.println( res );
		}


		public static int maxEnvelopes( int[][] envelopes ) {
				// Write your code here
				if( envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2 )
						return 0;
				Arrays.sort( envelopes, new Comparator<int[]>( ) {
						public int compare( int[] arr1, int[] arr2 ) {
								if( arr1[0] == arr2[0] )
										return arr2[1] - arr1[1];
								else
										return arr1[0] - arr2[0];
						}
				} );
				int dp[] = new int[envelopes.length];
				int len = 0;
				for( int[] envelope : envelopes ) {
						int index = Arrays.binarySearch( dp, 0, len, envelope[1] );
						if( index < 0 )
								index = -index - 1;
						dp[index] = envelope[1];
						if( index == len )
								len++;
				}
				return len;
		}


		public static String getS( String s ) {
				if( s == null || s.length( ) == 0 )
						return s;
				String s1 = s.toLowerCase( );
				String s2 = s.toUpperCase( );
				char[] chars = s.toCharArray( );
				char[] chs1 = s1.toCharArray( );
				char[] chs2 = s2.toCharArray( );
				String res = "";
				Set<Character> set = new HashSet<>( );
				for( int i = 0; i < chars.length; ++i ) {
						if( !set.contains( chars[i] ) ) {
								set.add( chs1[i] );
								set.add( chs2[i] );
								res += chars[i];
						}
				}
				return res;
		}
}
