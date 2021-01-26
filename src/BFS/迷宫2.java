package BFS;

/**
 * Created by wyh on 2019/6/2.
 */
public class 迷宫2 {
		class Point {
				int x;
				int y;
				int l;

				public Point( int x, int y, int l ) {
						this.x = x;
						this.y = y;
						this.l = l;
				}
		}


		//走到目的地的最短路径
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		int destX;
		int destY;

		public int shortestDistance( int[][] maze, int[] start, int[] destination ) {
				destX = destination[0];
				destY = destination[1];
				int n = maze.length;
				int m = maze[0].length;
				int[][] length = new int[n][m];
				for( int i = 0; i < n; i++ ) {
						for( int j = 0; j < m; j++ ) {
								length[i][j] = Integer.MAX_VALUE;
						}
				}
				dfs( start[0], start[1], 0, maze, length );
				return length[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : length[destination[0]][destination[1]];
		}

		private void dfs( int x, int y, int l, int[][] maze, int[][] length ) {
				if( l >= length[x][y] ) {
						return;
				}
				length[x][y] = l;
				for( int i = 0; i < 4; i++ ) {
						int nx = x;
						int ny = y;
						int nl = l;
						while( nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && maze[nx][ny] == 0 ) {
								nx += dx[i];
								ny += dy[i];
								nl += 1;
						}
						//已经走到了墙里， 需要回退一步
						nx -= dx[i];
						ny -= dy[i];
						nl -= 1;
						dfs( nx, ny, nl, maze, length );
				}
		}
}
