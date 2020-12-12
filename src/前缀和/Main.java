package 前缀和;

import java.util.Scanner;

/**
 * @author wangyh
 * @create 2020-03-01 10:02
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 7;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] * 6 + dp[i - 1];
        }
        System.out.println(dp[n] * 2);
    }
}
