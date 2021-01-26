package BFS;

import java.util.*;

/**
 * Created by wyh on 2019/6/2.
 */
public class 单词接龙 {
		public int ladderLength( String start, String end, Set<String> dict ) {
				if( dict == null ) {
						return 0;
				}
				if( start.equals( end ) ) {
						return 1;
				}
				int cnt = 1;
				dict.add( start );
				dict.add( end );
				Queue<String> queue = new LinkedList<>( );
				Set<String> hash = new HashSet<>( );
				queue.add( start );
				hash.add( start );
				while( !queue.isEmpty( ) ) {
						cnt++;
						int size = queue.size( );
						for( int i = 0; i < size; i++ ) {
								String cur = queue.poll( );
								for( String next : getNexts( dict, cur ) ) {
										if( hash.contains( next ) ) {
												continue;
										}
										if( next.equals( end ) ) {
												return cnt;
										}
										queue.add( next );
										hash.add( next );
								}
						}
				}
				return cnt;
		}

		private List<String> getNexts( Set<String> set, String word ) {
				List<String> result = new ArrayList<>( );
				for( char c = 'a'; c <= 'z'; ++c ) {
						for( int i = 0; i < word.length( ); ++i ) {
								if( c == word.charAt( i ) ) {
										continue;
								}
								String next = replace( word, i, c );
								if( set.contains( next ) ) {
										result.add( next );
								}
						}
				}
				return result;
		}

		private String replace( String word, int idx, char c ) {
				char[] chs = word.toCharArray( );
				chs[idx] = c;
				return new String( chs );
		}
}
