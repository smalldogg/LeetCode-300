package 二分;

/**
 * Created by wyh on 2019/5/30.
 */
public class 第一个错误的代码版本 {
		public static class SVNRepo {
				public static boolean isBadVersion( int k ) {
						return true;
				}
		}

		public int findFirstBadVersion( int n ) {
				int start = 1, end = n;
				while( start + 1 < end ) {
						int mid = start + ( end - start ) / 2;
						if( SVNRepo.isBadVersion( mid ) ) {
								end = mid;
						} else
								start = mid;
				}
				if( SVNRepo.isBadVersion( start ) )
						return start;
				return end;
		}
}
