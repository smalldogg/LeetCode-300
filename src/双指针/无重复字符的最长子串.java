package 双指针;

/**
 * @author wangyh
 * @create 2020-06-20 21:28
 */

public class 无重复字符的最长子串 {
		public int lengthOfLongestSubstring( String s ) {
				if( s == null || s.length( ) == 0 )
						return 0;
				int max = Integer.MIN_VALUE;
				int[] count = new int[256];
				char[] chs = s.toCharArray( );
				for( int l = 0, r = 0; r < s.length( ); ++r ) {
						count[chs[r]]++;
						while( count[chs[r]] > 1 ) {
								count[chs[l]]--;
								l++;
						}
						max = Math.max( max, r - l + 1 );
				}
				return max;
		}
}
