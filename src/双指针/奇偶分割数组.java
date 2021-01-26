package 双指针;

public class 奇偶分割数组 {
		public void partitionArray( int[] nums ) {
				if( nums == null || nums.length == 0 ) {
						return;
				}
				int l = 0, r = nums.length - 1;
				while( l <= r ) {
						while( l <= r && nums[l] % 2 == 1 ) {
								l++;
						}
						while( l <= r && nums[r] % 2 == 0 ) {
								r--;
						}
						if( l <= r ) {
								int temp = nums[l];
								nums[l] = nums[r];
								nums[r] = temp;
								l++;
								r--;
						}
				}
		}
}
