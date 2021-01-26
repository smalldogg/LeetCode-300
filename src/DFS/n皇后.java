package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class n皇后 {

		Set<Integer> col = new HashSet<>( ); //同列
		Set<Integer> dif = new HashSet<>( );//斜线
		Set<Integer> sum = new HashSet<>( );//斜线

		public List<List<String>> solveNQueens( int n ) {
				List<List<String>> results = new ArrayList<>( );
				char[][] chs = new char[n][n];
				for( int i = 0; i < n; i++ ) {
						for( int j = 0; j < n; j++ ) {
								chs[i][j] = '.';
						}
				}
				dfs( 0, n, chs, results );
				return results;
		}

		private void dfs( int level, int n, char[][] chs, List<List<String>> results ) {
				if( level == n ) {
						List<String> list = new ArrayList<>( );
						for( int i = 0; i < n; i++ ) {
								list.add( String.valueOf( chs[i] ) );
						}
						results.add( list );
						return;
				}
				for( int i = 0; i < n; i++ ) {
						if( !col.contains( i ) && !dif.contains( level + i ) && !sum.contains( level - i ) ) {
								col.add( i );
								dif.add( level + i );
								sum.add( level - i );
								chs[level][i] = 'Q';
								dfs( level + 1, n, chs, results );

								col.remove( i );
								dif.remove( level + i );
								sum.remove( level - i );
								chs[level][i] = '.';
						}
				}
		}
}
