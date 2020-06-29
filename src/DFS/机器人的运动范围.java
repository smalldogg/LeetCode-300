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

    private int dfs(int i, int j, int m, int n, int k, boolean[][] v) {
        if (i < 0 || i >= m || j < 0 || j >= n
                || getSum(i) + getSum(j) > k || v[i][j]) return 0;
        v[i][j] = true;
        return dfs(i + 1, j, m, n, k, v) + dfs(i - 1, j, m, n, k, v) +
                dfs(i, j + 1, m, n, k, v) + dfs(i, j - 1, m, n, k, v) + 1;

    }


    private int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
