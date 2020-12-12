package DFS;

import java.util.*;

public class 单词接龙2 {
		public List<List<String>> findLadders( String start, String end, Set<String> dict ) {
				List<List<String>> results = new ArrayList<>( );
				dict.add( start );
				dict.add( end );
				Map<String, Integer> distance = new HashMap<>( ); //从start到每个单词的变化距离
				Map<String, List<String>> map = new HashMap<>( ); //每个单词的变化链表
				dict.add( start );
				dict.add( end );

				bfs( map, distance, start, end, dict );
				List<String> path = new ArrayList<String>( );

				dfs( results, path, end, start, distance, map );

				return results;
		}

		private void dfs( List<List<String>> ladders, List<String> path, String end, String start, Map<String, Integer> distance,
				Map<String, List<String>> map ) {
				path.add( end );
				if( end.equals( start ) ) {
						Collections.reverse( path );
						ladders.add( new ArrayList<>( path ) );
						Collections.reverse( path );
				} else {
						for( String next : map.get( end ) ) {
								if( distance.containsKey( next ) && distance.get( end ) == distance.get( next ) + 1 ) {
										dfs( ladders, path, next, start, distance, map );
								}
						}
				}
				path.remove( path.size( ) - 1 );
		}


		private void bfs( Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict ) {
				Queue<String> queue = new LinkedList<>( );
				queue.offer( start );
				distance.put( start, 0 );
				for( String str : dict ) {
						map.put( str, new ArrayList<>( ) );
				}

				while( !queue.isEmpty( ) ) {
						String cur = queue.poll( );
						List<String> nextList = expand( cur, dict );
						for( String next : nextList ) {
								map.get( next ).add( cur );
								if( !distance.containsKey( next ) ) {
										distance.put( next, distance.get( cur ) + 1 );
										queue.offer( next );
								}
						}
				}
		}

		private List<String> expand( String str, Set<String> set ) {
				List<String> list = new ArrayList<>( );
				for( int i = 0; i < str.length( ); i++ ) {
						for( char c = 'a'; c <= 'z'; c++ ) {
								if( c != str.charAt( i ) ) {
										String next = str.substring( 0, i ) + c + str.substring( i + 1 );
										if( set.contains( next ) ) {
												list.add( next );
										}
								}
						}
				}
				return list;
		}
}
