package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wyh on 2019/6/2.
 */
public class 骑士的最短路径2 {
    //单向bfs代码
    public int shortestPath2(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] || grid[m - 1][n - 1])
            return -1;
        if (m == 1 && n == 1)
            return 0;
        int[] dx = {1, -1, 2, -2};
        int[] dy = {2, 2, 1, 1};

        boolean[][] v = new boolean[grid.length][grid[0].length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        v[0][0] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                int cx = cur / n;
                int cy = cur % n;
                for (int k = 0; k < 4; k++) {
                    int nx = cx + dx[k];
                    int ny = cy + dy[k];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !grid[nx][ny] && !v[nx][ny]) {
                        if (nx == m - 1 && ny == n - 1) {
                            return cnt;
                        }
                        queue.offer(nx * n + ny);
                        v[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }

    //双向bfs
    public int shortestPath(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int m = grid.length, n = grid[0].length;

        if (grid[0][0] || grid[m - 1][n - 1]) {
            return -1;
        }
        if (m == 1 && n == 1) {
            return 0;
        }


        Queue<Integer> qA = new LinkedList<>();
        boolean[][] vA = new boolean[m][n];
        qA.offer(0);
        vA[0][0] = true;

        Queue<Integer> qB = new LinkedList<>();
        boolean[][] vB = new boolean[m][n];
        qB.offer(m * n - 1);
        vB[m - 1][n - 1] = true;

        int dist = 0, sign = 1;
        Queue<Integer> curQ = new LinkedList<>();
        boolean[][] vCur = null, vOp = null;
        int[] dx = {1, -1, 2, -2};
        int[] dy = {2, 2, 1, 1};

        while (!qA.isEmpty() && !qB.isEmpty()) {
            if (qA.size() <= qB.size()) {
                curQ = qA;
                vCur = vA;
                vOp = vB;
                sign = 1;
            } else {
                curQ = qB;
                vCur = vB;
                vOp = vA;
                sign = -1;
            }
            int size = curQ.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int cur = curQ.poll();
                int x = cur / n;
                int y = cur % n;
                for (int k = 0; k < 4; k++) {
                    int nx = x + sign * dx[k];
                    int ny = y + sign * dy[k];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !grid[nx][ny]) {
                        if (vOp[nx][ny])
                            return dist;

                        if (!vCur[nx][ny]) {
                            curQ.offer(nx * n + ny);
                            vCur[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
