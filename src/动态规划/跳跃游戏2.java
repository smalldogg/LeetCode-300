package 动态规划;

public class 跳跃游戏2 {
    //使用最少的跳跃次数到达数组的最后一个位置
    public int jump(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] + j >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[n - 1];
    }
}
