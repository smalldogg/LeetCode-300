package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wyh on 2019/6/2.
 */
public class 迷宫 {
		public boolean hasPath( int[][] maze, int[] start, int[] destination ) {
				int m = maze.length;
				int n = maze[0].length;
				boolean[][] v = new boolean[m][n];
				int[] dx = new int[]{ 0, -1, 0, 1 };
				int[] dy = new int[]{ 1, 0, -1, 0 };
				Queue<int[]> queue = new LinkedList<>( );
				v[start[0]][start[1]] = true;
				queue.offer( start );
				while( !queue.isEmpty( ) ) {
						int[] cur = queue.poll( );

						if( cur[0] == destination[0] && cur[1] == destination[1] ) {
								return true;
						}

						for( int k = 0; k < 4; k++ ) {
								int nx = cur[0];
								int ny = cur[1];
								// keeping rolling
								while( nx >= 0 && nx < maze.length && ny >= 0 && ny <= maze[0].length ) {
										nx += dx[k];
										ny += dy[k];
								}
								// rolling in the wall, must back one step
								nx -= dx[k];
								ny -= dy[k];
								if( !v[nx][ny] ) {
										v[nx][ny] = true;
										queue.offer( new int[]{ nx, ny } );
								}
						}
				}
				return false;
		}


		public boolean hasPath2( int[][] maze, int[] start, int[] destination ) {
				int m = maze.length;
				int n = maze[0].length;
				boolean[][] v = new boolean[m][n];

				Queue<Integer> queue = new LinkedList<>( );
				queue.offer( start[0] * n + start[1] );
				v[start[0]][start[1]] = true;

				int[] dir = { -1, 0, 1, 0, -1 };
				while( !queue.isEmpty( ) ) {
						int cur = queue.poll( );

						for( int k = 0; k < 4; k++ ) {
								int cx = cur / n;
								int cy = cur % n;
								while( cx >= 0 && cx < maze.length && cy >= 0 && cy <= maze[0].length ) {
										cx += dir[k];
										cy += dir[k + 1];
								}
								cx -= dir[k];
								cy -= dir[k + 1];
								if( cx == destination[0] && cy == destination[1] ) {
										return true;
								}
								if( v[cx][cy] ) {
										queue.offer( cx * n + cy );
										v[cx][cy] = true;
								}
						}
				}
				return false;
		}
}
