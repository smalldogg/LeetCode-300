package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
		public List<List<Integer>> threeSum( int[] nums ) {
				List<List<Integer>> results = new ArrayList<>( );
				if( nums == null || nums.length == 0 ) {
						return results;
				}
				Arrays.sort( nums );
				for( int i = 0; i < nums.length - 2; i++ ) {
						if( i > 0 && nums[i] == nums[i - 1] ) {
								continue;
						}
						twosum( results, nums, -nums[i], i + 1 );
				}
				return results;
		}


		private void twosum( List<List<Integer>> results, int[] nums, int target, int start ) {
				int l = start;
				int r = nums.length - 1;
				while( l < r ) {
						int sum = nums[l] + nums[r];
						if( sum == target ) {
								List<Integer> list = new ArrayList<>( );
								list.add( nums[l] );
								list.add( nums[r] );
								list.add( -target );
								results.add( list );
								l++;
								r--;
								while( l < r && nums[l] == nums[l - 1] )
										l++;
								while( l < r && nums[r] == nums[r + 1] )
										r--;
						} else if( sum < target )
								l++;
						else
								r--;
				}
		}
}
