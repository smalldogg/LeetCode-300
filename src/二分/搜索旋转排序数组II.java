package 二分;

/**
 * Created by wyh on 2019/5/30.
 */
public class 搜索旋转排序数组II {
		public boolean search( int[] nums, int target ) {
				for( int i = 0; i < nums.length; i++ ) {
						if( nums[i] == target ) {
								return true;
						}
				}
				return false;
		}
}
