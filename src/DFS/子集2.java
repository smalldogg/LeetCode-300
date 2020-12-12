package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集2 {
		//跳跃型的dfs
		public List<List<Integer>> subsetsWithDup( int[] nums ) {
				List<List<Integer>> results = new ArrayList<>( );
				if( nums == null ) {
						return results;
				}
				List<Integer> list = new ArrayList<>( );
				Arrays.sort( nums );
				help( nums, 0, list, results );
				return results;
		}

		//1.递归的定义：找到所有的子集
		private void help( int[] nums, int start, List<Integer> list, List<List<Integer>> results ) {
				//3.递归的出口
				results.add( new ArrayList<>( list ) );
				//2.递归的拆解
				for( int i = start; i < nums.length; i++ ) {
						//如果 i - 1 被放进去了 ， 那么 i 的值变为 start
						//上一个挑的数字是 start - 1,  i - 1 没有放到集合中  现在挑的数字是 start + 1
						if( i != 0 && nums[i] == nums[i - 1] && i != start ) {
								continue;
						}
						list.add( nums[i] );
						help( nums, i + 1, list, results );
						list.remove( list.size( ) - 1 );
				}
		}
}
