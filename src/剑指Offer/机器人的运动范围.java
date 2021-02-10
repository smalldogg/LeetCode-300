package 剑指Offer;

/**
 * @author wangyh
 * @create 2020-02-13 10:12
 */

public class 机器人的运动范围 {
    int count = 0;

    public int movingCount(int m, int n, int k) {
        boolean[][] v = new boolean[m][n];
        dfs(0, 0, m, n, k, v);
        return count;
    }

    private void dfs(int i, int j, int m, int n, int k, boolean[][] v) {
        if (!check(i, j, m, n, k, v))
            return;
        v[i][j] = true;
        count++;
        dfs(i + 1, j, m, n, k, v);
        dfs(i, j + 1, m, n, k, v);
        dfs(i - 1, j, m, n, k, v);
        dfs(i, j - 1, m, n, k, v);
    }

    private boolean check(int i, int j, int m, int n, int k, boolean[][] v) {
        if (i >= 0 && i < m && j >= 0 && j < n && !v[i][j] && (getDigitSum(i) + getDigitSum(j)) <= k)
            return true;
        else
            return false;
    }

    private int getDigitSum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
