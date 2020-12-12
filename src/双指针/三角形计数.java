package 双指针;

import java.util.Arrays;

public class 三角形计数 {
		public int triangleCount( int[] nums ) {
				int res = 0;
				if( nums == null || nums.length == 0 ) {
						return res;
				}
				Arrays.sort( nums );
				for( int i = 2; i < nums.length; i++ ) {
						int l = 0, r = i - 1;
						while( l < r ) {
								int sum = nums[l] + nums[r];
								if( sum > nums[i] ) {
										res += r - l;
										r--;
								} else {
										l++;
								}
						}
				}
				return res;
		}
}
