package 二叉树和分治法;

/**
 * @author wangyh
 * @create 2020-07-15 13:18
 */

public class 不同的二叉搜索树 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {

            }
        }
        return dp[n];
    }
}
