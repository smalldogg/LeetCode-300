package 数组;

import java.util.*;

public class 查找数组中的所有重复项 {
		public List<Integer> findDuplicates( int[] nums ) {
				List<Integer> result = new ArrayList<>( );
				Set<Integer> set = new HashSet<>( );
				for( int i = 0; i < nums.length; i++ ) {
						if( set.contains( nums[i] ) ) {
								result.add( nums[i] );
						} else {
								set.add( nums[i] );
						}
				}
				return result;
		}

		//不使用额外空间的做法
		public List<Integer> findDuplicates2( int[] nums ) {
				List<Integer> result = new ArrayList<>( );
				if( nums == null || nums.length == 0 ) {
						return result;
				}
				for( int i = 0; i < nums.length; i++ ) {
						int idx = Math.abs( nums[i] ) - 1;
						if( nums[idx] < 0 ) {
								result.add( -nums[idx] );
						} else {
								nums[idx] = -nums[idx];
						}
				}
				return result;
		}


}
