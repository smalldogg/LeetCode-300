package 双指针;

import java.util.List;

public class 恢复旋转排序数组 {
		public void recoverRotatedSortedArray( List<Integer> nums ) {
				for( int index = 0; index < nums.size( ) - 1; index++ ) {
						if( nums.get( index ) > nums.get( index + 1 ) ) {
								reverse( nums, 0, index );
								reverse( nums, index + 1, nums.size( ) - 1 );
								reverse( nums, 0, nums.size( ) - 1 );
								return;
						}
				}
		}

		private void reverse( List<Integer> nums, int i, int j ) {
				for( int a = i, b = j; a < b; a++, b-- ) {
						int temp = nums.get( a );
						nums.set( a, nums.get( b ) );
						nums.set( b, temp );
				}
		}
}
