package 双指针;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
		public int[] twoSum( int[] numbers, int target ) {
				int[] res = new int[2];
				if( numbers == null || numbers.length == 0 ) {
						return res;
				}
				Map<Integer, Integer> map = new HashMap<>( );
				for( int i = 0; i < numbers.length; i++ ) {
						if( map.containsKey( target - numbers[i] ) ) {
								res[0] = map.get( target - numbers[i] );
								res[1] = i;
						} else {
								map.put( numbers[i], i );
						}
				}
				return res;
		}
}
