package 动态规划;

/**
 * @author wangyh
 * @create 2021-01-30 23:03
 */


/**
 * dp[i]的定义：凑够 i 元钱所需最少的硬币数
 * dp[i] = math.min(dp[i - coins[j]] + 1, dp[i]);
 */
public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; ++j) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
