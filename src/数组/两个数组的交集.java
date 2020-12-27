package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 两个数组的交集 {

		public int[] intersection( int[] nums1, int[] nums2 ) {

				List<Integer> list = new ArrayList<>( );
				Arrays.sort( nums1 );
				Arrays.sort( nums2 );
				int i = 0, j = 0;
				while( i < nums1.length && j < nums2.length ) {
						if( i != 0 && nums1[i] == nums1[i - 1] ) {
								i++;
								continue;
						}
						if( nums1[i] > nums2[j] ) {
								j++;
						} else if( nums1[i] < nums2[j] ) {
								i++;
						} else {
								list.add( nums1[i] );
								i++;
								j++;
						}
				}
				int[] res = new int[list.size( )];
				int idx = 0;
				for( int ele : list ) {
						res[idx++] = ele;
				}
				return res;
		}
}
