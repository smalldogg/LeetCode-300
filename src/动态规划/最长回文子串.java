package 动态规划;

/**
 * @author wangyh
 * @create 2020-05-25 21:48
 */

public class 最长回文子串 {
    // dp[i - 1][j - 1] = dp[i - 1][j - 1]  + 1  if s[i] == s[j]
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int len = s.length();
        char[] chs = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        int begin = 0;
        int max = 1;
        for (int i = 0; i < len; ++i) dp[i][i] = true;
        for (int j = 1; j < len; ++j) {
            for (int i = 0; i < j; ++i) {
                if (chs[i] != chs[j]) dp[i][j] = false;
                else {
                    if (i - j < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
}
