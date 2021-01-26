package 双指针;

/**
 * @author wangyh
 * @create 2020-02-07 17:53
 */

public class 最长无重复字符的子串 {
		public int lengthOfLongestSubstring( String ss ) {
				int max = Integer.MIN_VALUE;
				int[] map = new int[256];
				char[] s = ss.toCharArray( );
				for( int l = 0, r = 0; r < s.length; ++r ) {
						map[s[r]]++;
						while( map[s[r]] > 1 ) {
								map[s[l]]--;
								l++;
						}
						max = Math.max( max, r - l + 1 );
				}
				return max;
		}
}
