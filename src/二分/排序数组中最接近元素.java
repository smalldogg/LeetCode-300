package 二分;

public class 排序数组中最接近元素 {
		public int closestNumber( int[] nums, int target ) {
				if( nums == null || nums.length == 0 ) {
						return -1;
				}
				int start = 0, end = nums.length - 1;
				while( start + 1 < end ) {
						int mid = ( start + end ) / 2;
						if( nums[mid] == target ) {
								return mid;
						} else if( nums[mid] > target ) {
								end = mid;
						} else {
								start = mid;
						}
				}
				if( Math.abs( nums[start] - target ) < Math.abs( nums[end] - target ) ) {
						return start;
				}
				return end;
		}
}
