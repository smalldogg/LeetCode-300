package DFS;

/**
 * @author wangyh
 * @create 2020-05-27 20:12
 */

public class 机器人的运动范围 {
    public int movingCount(int m, int n, int k) {
        boolean[][] v = new boolean[m][n];
        return dfs(0, 0, m, n, k, v);
    }

    private int dfs(int x, int y, int m, int n, int k, boolean[][] v) {
        if (x < 0 || x >= m || y < 0 || y >= n ||
                v[x][y] || (getSum(x) + getSum(y)) > k) return 0;
        v[x][y] = true;
        return 1 + dfs(x + 1, y, m, n, k, v)
								 + dfs(x - 1, y, m, n, k, v)
                 + dfs(x, y + 1, m, n, k, v)
							   + dfs(x, y - 1, m, n, k, v);
    }

    private int getSum(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
