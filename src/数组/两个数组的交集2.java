package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 两个数组的交集2 {
		public int[] intersection( int[] nums1, int[] nums2 ) {
				Arrays.sort( nums1 );
				Arrays.sort( nums2 );
				int i = 0, j = 0;
				List<Integer> list = new ArrayList<>( );
				while( i < nums1.length && j < nums2.length ) {
						if( nums1[i] == nums2[j] ) {
								list.add( nums1[i] );
								i++;
								j++;
						} else if( nums1[i] > nums2[j] ) {
								j++;
						} else {
								i++;
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
