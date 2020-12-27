package 二分;

/**
 * Created by wyh on 2019/5/30.
 */
public class 寻找旋转排序数组中的最小值 {
		public int findMin( int[] nums ) {
				if( nums == null || nums.length == 0 )
						return -1;
				int start = 0, end = nums.length - 1;
				int target = nums[end];
				while( start + 1 < end ) {
						int mid = ( start + end ) / 2;
						if( nums[mid] > target )
								start = mid;
						else if( nums[mid] < target )
								end = mid;
						else
								end = mid;
				}
				if( nums[start] <= target )
						return nums[start];
				else
						return nums[end];
		}
}
