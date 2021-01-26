package 数组;

/**
 * @author wangyh
 * @create 2020-11-19 17:46
 */

public class 移动零 {
		public void moveZeroes( int[] nums ) {
				if( nums == null )
						return;
				int idx = 0;
				for( int i = 0; i < nums.length; ++i ) {
						if( nums[i] != 0 )
								nums[idx++] = nums[i];
				}
				while( idx < nums.length )
						nums[idx++] = 0;
		}
}
