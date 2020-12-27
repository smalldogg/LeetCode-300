package 二分;

/**
 * Created by wyh on 2019/5/30.
 */
public class 搜索区间 {
		public int[] searchRange( int[] nums, int target ) {
				if( nums == null || nums.length == 0 ) {
						return new int[]{ -1, -1 };
				}
				int[] res = new int[2];
				int start = 0, end = nums.length - 1, mid;
				//找第一个
				while( start + 1 < end ) {
						mid = ( start + end ) / 2;
						if( nums[mid] > target ) {
								end = mid;
						} else if( nums[mid] < target ) {
								start = mid;
						} else {
								end = mid;
						}
				}
				if( nums[start] == target ) {
						res[0] = start;
				} else if( nums[end] == target ) {
						res[0] = end;
				} else {
						res[0] = res[1] = -1;
						return res;
				}
				//找最后一个
				start = 0;
				end = nums.length - 1;
				while( start + 1 < end ) {
						mid = start + ( end - start ) / 2;
						if( nums[mid] == target ) {
								start = mid;
						} else if( nums[mid] < target ) {
								start = mid;
						} else {
								end = mid;
						}
				}
				if( nums[end] == target ) {
						res[1] = end;
				} else if( nums[start] == target ) {
						res[1] = start;
				} else {
						res[0] = res[1] = -1;
						return res;
				}

				return res;
		}
}
