package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangyh
 * @create 2020-03-04 16:36
 */

public class 腐烂的橘子 {


    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    qx.offer(i);
                    qy.offer(j);
                } else if (grid[i][j] == 1) {
                    num++;
                }
            }
        }
        int res = bfs(grid, qx, qy, num);
        return res;
    }


    private int bfs(int[][] grid, Queue<Integer> qx, Queue<Integer> qy, int num) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int cnt = 0;
        while (!qx.isEmpty() && num > 0) {
            cnt++;
            int size = qx.size();
            for (int i = 0; i < size; ++i) {
                int curX = qx.poll();
                int curY = qy.poll();
                for (int k = 0; k < 4; ++k) {
                    int nextX = curX + dx[k];
                    int nextY = curY + dy[k];
                    if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = 2;
                        qx.offer(nextX);
                        qy.offer(nextY);
                        num--;
                    }
                }
            }
        }
        return num == 0 ? cnt : -1;
    }
}
