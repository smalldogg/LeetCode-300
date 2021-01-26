package BFS;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wyh on 2019/6/2.
 */
public class 不同岛屿的个数 {


		int n = 0, m = 0;
		Set<String> S = new HashSet<>( );
		String tmp = "";
		boolean[][] vis = null;
		int ix = 0, iy = 0;
		int[] qx = new int[]{ 1, -1, 0, 0 };
		int[] qy = new int[]{ 0, 0, 1, -1 };

		public int numberofDistinctIslands( int[][] grid ) {
				n = grid.length;
				m = grid[0].length;
				vis = new boolean[n][m];
				for( int i = 0; i < n; ++i ) {
						for( int j = 0; j < m; ++j ) {
								if( grid[i][j] == 1 && !vis[i][j] ) {
										tmp = "";
										ix = i;
										iy = j;
										dfs( i, j, grid );
										S.add( tmp );
								}
						}
				}
				return S.size( );
		}

		public void dfs( int x, int y, int grid[][] ) {
				vis[x][y] = true;
				tmp += ( x - ix ) + "" + ( y - iy );
				for( int i = 0; i < 4; ++i ) {
						int nx = x + qx[i], ny = y + qy[i];
						if( nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny] || grid[nx][ny] == 0 )
								continue;
						dfs( nx, ny, grid );
				}
		}
}
