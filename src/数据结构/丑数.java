package 数据结构;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author wangyh
 * @create 2020-03-04 17:11
 */

public class 丑数 {
		public int nthUglyNumber( int n ) {
				Set<Long> set = new HashSet<>( );

				PriorityQueue<Long> queue = new PriorityQueue<>( );
				long[] next = new long[]{ 2, 3, 5 };
				for( long num : next ) {
						set.add( num );
						queue.offer( num );
				}
				Long res = 1L;
				for( int i = 1; i < n; ++i ) {
						res = queue.poll( );
						for( int j = 0; j < 3; ++j ) {
								if( !set.contains( res * next[j] ) ) {
										set.add( res * next[j] );
										queue.offer( res * next[j] );
								}
						}
				}
				return res.intValue( );
		}
}
