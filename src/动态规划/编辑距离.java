package 动态规划;

/**
 * @author wangyh
 * @create 2020-07-25 16:15
 */

public class 编辑距离 {
    //dp[i][j] word1 的前i个字符转成word2
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        //init
        dp[0][0] = 0;
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        for (int i = 0; i <= len1; ++i)
            dp[0][i] = i;
        for (int j = 0; j <= len2; ++j)
            dp[j][0] = j;
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (chs1[i - 1] == chs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 如果不等于
                    //增 删 替
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
