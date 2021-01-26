package 二分;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyh on 2019/5/30.
 */
public class 恢复旋转排序数组 {
		public void recoverRotatedSortedArray( List<Integer> nums ) {
				for( int i = 0; i < nums.size( ) - 1; i++ ) {
						if( nums.get( i ) > nums.get( i + 1 ) ) {
								reverse( nums, 0, i );
								reverse( nums, i + 1, nums.size( ) - 1 );
								reverse( nums, 0, nums.size( ) - 1 );
						}
				}
		}

		private void reverse( List<Integer> nums, int start, int end ) {
				for( int i = start, j = end; i < j; i++, j-- ) {
						int temp = nums.get( i );
						nums.set( i, nums.get( j ) );
						nums.set( j, temp );
				}
		}

		//当含有重复元素的时候
		public static void reverseArrayList( ArrayList<Integer> nums, int start, int end ) {

				while( start < end ) {
						nums.set( start, nums.get( start ) ^ nums.get( end ) );
						nums.set( end, nums.get( start ) ^ nums.get( end ) );
						nums.set( start, nums.get( start ) ^ nums.get( end ) );
						start++;
						end--;
				}
		}

}
