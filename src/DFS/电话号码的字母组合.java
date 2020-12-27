package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {
		//dfs的组合问题
		public List<String> letterCombinations( String digits ) {
				List<String> result = new ArrayList<>( );
				if( digits == null || digits.equals( "" ) ) {
						return result;
				}

				Map<Character, char[]> map = new HashMap<Character, char[]>( );
				map.put( '2', new char[]{ 'a', 'b', 'c' } );
				map.put( '3', new char[]{ 'd', 'e', 'f' } );
				map.put( '4', new char[]{ 'g', 'h', 'i' } );
				map.put( '5', new char[]{ 'j', 'k', 'l' } );
				map.put( '6', new char[]{ 'm', 'n', 'o' } );
				map.put( '7', new char[]{ 'p', 'q', 'r', 's' } );
				map.put( '8', new char[]{ 't', 'u', 'v' } );
				map.put( '9', new char[]{ 'w', 'x', 'y', 'z' } );
				StringBuilder sb = new StringBuilder( );
				dfs( map, digits, sb, result );

				return result;
		}

		private void dfs( Map<Character, char[]> map, String digits, StringBuilder sb, List<String> result ) {

				if( sb.length( ) == digits.length( ) ) {
						result.add( sb.toString( ) );
						return;
				}

				for( char c : map.get( digits.charAt( sb.length( ) ) ) ) {
						sb.append( c );
						dfs( map, digits, sb, result );
						sb.deleteCharAt( sb.length( ) - 1 );
				}
		}
}
