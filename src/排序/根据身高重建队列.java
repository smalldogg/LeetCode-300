package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wangyh
 * @create 2020-11-16 16:04
 */

public class 根据身高重建队列 {
		public int[][] reconstructQueue( int[][] people ) {
				if( people == null || people[0].length == 0 )
						return new int[0][0];
				Arrays.sort( people, new Comparator<int[]>( ) {
						@Override public int compare( int[] o1, int[] o2 ) {
								return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
						}
				} );
				List<int[]> result = new ArrayList<>( );
				//K值定义为 排在h前面且身高大于或等于h的人数
				//因为从身高降序开始插入，此时所有人身高都大于等于h
				//因此K值即为需要插入的位置
				for( int[] i : people )
						result.add( i[1], i );
				return result.toArray( new int[result.size( )][] );
		}
}
