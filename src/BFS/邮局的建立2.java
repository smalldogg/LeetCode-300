package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wyh on 2019/6/2.
 */
public class 邮局的建立2 {
		public int shortestDistance( int[][] grid ) {
				if( grid == null || grid.length == 0 || grid[0].length == 0 ) {
						return 0;
				}
				int cnt = Integer.MAX_VALUE;
				for( int i = 0; i < grid.length; i++ ) {
						for( int j = 0; j < grid[0].length; j++ ) {
								if( grid[i][j] == 0 ) {
										cnt = Math.min( bfs( grid, i, j ), cnt );
								}
						}
				}
				return cnt == Integer.MAX_VALUE ? -1 : cnt;
		}

		//墙 2 ，房子 1，以及空 0
		private int bfs( int[][] grid, int x, int y ) {
				Queue<Integer> qx = new LinkedList<>( );
				Queue<Integer> qy = new LinkedList<>( );
				boolean[][] visited = new boolean[grid.length][grid[0].length];
				qx.offer( x );
				qy.offer( y );
				int[] dx = { 0, 0, 1, -1 };
				int[] dy = { 1, -1, 0, 0 };
				visited[x][y] = true;
				int sum = 0;
				int dist = 0;
				while( !qx.isEmpty( ) ) {
						//扩展内部使用dis
						dist++;
						int size = qx.size( );
						for( int i = 0; i < size; i++ ) {
								int cx = qx.poll( );
								int cy = qy.poll( );
								for( int k = 0; k < 4; k++ ) {
										int nx = cx + dx[k];
										int ny = cy + dy[k];
										if( 0 <= nx && nx < grid.length && ny >= 0 && ny < grid[0].length && !visited[nx][ny] ) {
												visited[nx][ny] = true;
												if( grid[nx][ny] == 1 ) {
														sum += dist;
												}
												if( grid[nx][ny] == 0 ) {
														qx.offer( nx );
														qy.offer( ny );
												}
										}
								}
						}
				}
				for( int i = 0; i < grid.length; i++ ) {
						for( int j = 0; j < grid[0].length; j++ ) {
								if( grid[i][j] == 1 && !visited[i][j] ) {
										return Integer.MAX_VALUE;
								}
						}
				}
				return sum;
		}
}
