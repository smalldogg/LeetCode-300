package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wyh on 2019/6/2.
 */
public class 骑士的最短路径 {

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        visited[source.x][source.y] = true;
        int cnt = 0;
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        while (!queue.isEmpty()) {
            //即将扩展
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point c = queue.poll();
                for (int k = 0; k < 8; k++) {
                    int nx = c.x + dx[k];
                    int ny = c.y + dy[k];
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !grid[nx][ny] && !visited[nx][ny]) {
                        if (nx == destination.x && ny == destination.y) {
                            return cnt;
                        }
                        Point next = new Point(nx, ny);
                        visited[nx][ny] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}
