package 双指针;

import java.util.Arrays;

public class 两数和的最接近值 {
		public int twoSumClosest( int[] nums, int target ) {
				int best = Integer.MAX_VALUE;
				if( nums == null || nums.length == 0 ) {
						return 0;
				}
				Arrays.sort( nums );
				int l = 0, r = nums.length - 1;
				while( l < r ) {
						if( nums[l] + nums[r] < target ) {
								best = Math.min( best, target - nums[l] - nums[r] );
								l++;
						} else {
								best = Math.min( best, nums[l] + nums[r] - target );
								r--;
						}
				}
				return best;
		}
}
