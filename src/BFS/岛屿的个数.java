package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wyh on 2019/6/2.
 */
public class 岛屿的个数 {
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int cnt = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j]) {
                    bfs(grid, i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(boolean[][] grid, int i, int j, boolean[][] visited) {
        int[] dx = {0, 0, 1, -1,};
        int[] dy = {1, -1, 0, 0};
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(i);
        qy.offer(j);
        visited[i][j] = true;
        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length &&
                        !visited[nx][ny] && grid[nx][ny]) {
                    qx.offer(nx);
                    qy.offer(ny);
                    visited[nx][ny] = true;
                }
            }
        }
    }


       public int numIslands2(char[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }
        int result = 0;
        int N = grid.length;
        int M = grid[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    infect(grid, i, j, N, M);
                }
            }
        }
        return result;
    }


    private void infect(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '2') return; //invaild
        grid[i][j] = '2';
        infect(grid, i, j, n, m);
        infect(grid, i, j, n, m);
        infect(grid, i, j, n, m);
        infect(grid, i, j, n, m);
    }

}

