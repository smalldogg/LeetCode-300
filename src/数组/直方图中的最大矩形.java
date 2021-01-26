package 数组;

import java.util.Stack;

/**
 * @author wangyh
 * @create 2020-02-28 10:17
 */

public class 直方图中的最大矩形 {
		public int largestRectangleAreaExpand( int[] heights ) {
				if( heights == null || heights.length == 0 )
						return 0;
				int max = 0, n = heights.length;
				for( int i = 0; i < n; ++i ) {
						int l = i, r = i;
						while( l >= 0 && heights[l] >= heights[i] )
								l--;
						while( r < n && heights[r] >= heights[i] )
								r++;
						max = Math.max( max, heights[i] * ( r - l - 1 ) );
				}
				return max;
		}


		public int largestRectangleAreaStack( int[] heights ) {
				if( heights == null || heights.length == 0 )
						return 0;
				int max = 0, n = heights.length;
				Stack<Integer> stack = new Stack<>( );
				stack.push( -1 );
				for( int i = 0; i < n; ++i ) {
						while( stack.peek( ) != -1 && heights[stack.peek( )] >= heights[i] ) {
								int heigh = heights[stack.pop( )];
								max = Math.max( max, heigh * ( i - stack.peek( ) - 1 ) );
						}
						stack.push( i );
				}
				while( stack.peek( ) != -1 ) {
						int heigh = heights[stack.pop( )];
						max = Math.max( max, heigh * ( n - stack.peek( ) - 1 ) );
				}
				return max;
		}
}
