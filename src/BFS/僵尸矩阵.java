package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wyh on 2019/6/2.
 */
public class 僵尸矩阵 {
		//2 代表墙，1 代表僵尸，0 代表人类(数字 0, 1, 2)。
		public int zombie( int[][] grid ) {
				if( grid == null || grid.length == 0 || grid[0].length == 0 ) {
						return 0;
				}
				boolean[][] v = new boolean[grid.length][grid[0].length];
				Queue<Integer> qx = new LinkedList<>( );
				Queue<Integer> qy = new LinkedList<>( );
				for( int i = 0; i < grid.length; i++ ) {
						for( int j = 0; j < grid[0].length; j++ ) {
								if( grid[i][j] == 1 ) {
										v[i][j] = true;
										qx.offer( i );
										qy.offer( j );
								}
						}
				}
				int cnt = bfs( grid, qx, qy, v );
				for( int i = 0; i < grid.length; i++ ) {
						for( int j = 0; j < grid[0].length; j++ ) {
								if( grid[i][j] == 0 && !v[i][j] ) {
										return -1;
								}
						}
				}
				return cnt;
		}

		private int bfs( int[][] grid, Queue<Integer> qx, Queue<Integer> qy, boolean[][] v ) {
				int cnt = 0;
				int[] dx = { 0, 0, 1, -1 };
				int[] dy = { 1, -1, 0, 0 };
				while( !qx.isEmpty( ) ) {
						int size = qx.size( );
						cnt++;
						for( int i = 0; i < size; i++ ) {
								int cx = qx.poll( );
								int cy = qy.poll( );
								for( int k = 0; k < 4; k++ ) {
										int nx = cx + dx[k];
										int ny = cy + dy[k];
										if( nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !v[nx][ny] && grid[nx][ny] == 0 ) {
												qx.offer( nx );
												qy.offer( ny );
												v[nx][ny] = true;
										}
								}
						}
				}
				//因为最后一次加入的僵尸已经没有人类可以感染，但是队列不为空
				return cnt - 1;
		}

}
