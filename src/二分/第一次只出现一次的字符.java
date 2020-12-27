package 二分;

/**
 * Created by wyh on 2019/5/30.
 */
public class 第一次只出现一次的字符 {
		public char firstUniqChar( String str ) {
				int[] cnt = new int[256];
				for( char c : str.toCharArray( ) ) {
						cnt[c]++;
				}
				for( char c : str.toCharArray( ) ) {
						if( cnt[c] == 1 ) {
								return c;
						}
				}
				return '0';
		}
}
