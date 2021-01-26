package 二分;

/**
 * @author wangyh
 * @create 2020-02-02 20:57
 */

public class 二分枚举 {

		int n, c;
		int[] pos = new int[10005];

		boolean judge( int k ) {
				int cnt = 1;
				int st = pos[0];
				for( int i = 1; i < n; ++i ) {
						if( pos[i] - st >= k ) {
								++cnt;
								if( cnt >= c )
										return true;
								st = pos[i];
						}
				}
				return false;
		}

		public int binary_search( )  // 二分枚举满足条件的最大距离
		{
				int left = 0;
				int right = pos[n - 1] - pos[0];
				int mid = ( left + right ) >> 1;
				while( left <= right ) {
						if( judge( mid ) )  // 所求距离 >= mid，可以继续增大试探
								left = mid + 1;
						else            // 所求距离 < mid,所以必须减小来试探
								right = mid - 1;
						mid = ( left + right ) >> 1;
				}
				return left - 1;
		}
}
