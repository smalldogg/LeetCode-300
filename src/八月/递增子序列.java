package 八月;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wangyh
 * @create 2020-08-29 23:08
 */

public class 递增子序列 {
		/**
		 * 找到所有的递增子序列
		 *
		 * @param nums
		 * @return
		 */
		public List<List<Integer>> findSubsequences( int[] nums ) {
				if( nums == null || nums.length == 0 )
						return new ArrayList<>( );
				List<List<Integer>> results = new ArrayList<>( );
				List<Integer> path = new ArrayList<>( );
				dfs( nums, 0, results, path );
				return results;
		}

		private void dfs( int[] nums, int idx, List<List<Integer>> results, List<Integer> path ) {
				if( path.size( ) >= 2 )
						results.add( new ArrayList<>( path ) );
				HashSet<Integer> set = new HashSet<>( );
				for( int i = idx; i < nums.length; ++i ) {
						if( path.size( ) > 0 && nums[i] < path.get( path.size( ) - 1 ) || set.contains( nums[i] ) )
								continue;
						path.add( nums[i] );
						set.add( nums[i] );
						dfs( nums, i + 1, results, path );
						path.remove( path.size( ) - 1 );
				}
		}

}
