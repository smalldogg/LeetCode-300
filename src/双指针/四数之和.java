package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {
		public List<List<Integer>> fourSum( int[] nums, int target ) {
				List<List<Integer>> results = new ArrayList<>( );
				if( nums == null || nums.length == 0 ) {
						return results;
				}
				Arrays.sort( nums );
				for( int i = 0; i < nums.length - 3; i++ ) {
						if( i != 0 && nums[i] == nums[i - 1] ) {
								continue;
						}
						for( int j = i + 1; j < nums.length - 2; j++ ) {
								if( j != i + 1 && nums[j] == nums[j - 1] ) {
										continue;
								}
								twoSum( nums, target - ( nums[i] + nums[j] ), results, i, j );
						}
				}
				return results;
		}

		private void twoSum( int[] nums, int target, List<List<Integer>> results, int startI, int startJ ) {
				int l = startJ + 1;
				int r = nums.length - 1;
				while( l < r ) {
						int sum = nums[l] + nums[r];
						if( sum == target ) {
								List<Integer> list = new ArrayList<>( );
								list.add( nums[startI] );
								list.add( nums[startJ] );
								list.add( nums[l] );
								list.add( nums[r] );
								results.add( list );
								l++;
								r--;
								while( l < r && nums[l] == nums[l - 1] ) {
										l++;
								}
								while( l < r && nums[r] == nums[r + 1] ) {
										r--;
								}
						} else if( sum < target ) {
								l++;
						} else {
								r--;
						}
				}
		}
}
