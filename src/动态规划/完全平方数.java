package 动态规划;

/**
 * @author wangyh
 * @create 2020-05-19 10:57
 */

public class 完全平方数 {
    public int numSquares(int n) {
        if (n <= 0)
            return -1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = 1;
            for (int j = 1; j < i; ++j) {
                if (i - j * j >= 0)
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
