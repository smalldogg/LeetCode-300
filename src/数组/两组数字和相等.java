package 数组;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyh
 * @create 2020-02-28 16:18
 */

public class 两组数字和相等 {
    public List<List<Integer>> find(int num) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        while (num != 0) {
            int n = num % 10;
            sum += n;
            list.add(n);
            num = num / 10;
        }
        Integer[] nums = list.toArray(new Integer[list.size()]);
        int target = sum / 2;
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 2};
        int num = getNum(nums);
        System.out.println(num);
    }

    public static int getNum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int target = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; ++i) target += nums[i];
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        int i, j;
        for (j = 1; j <= target; ++j) dp[0][j] = false;
        for (i = 1; i <= n; ++i) {
            for (j = 1; j <= target; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1])
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i][j];
            }
        }
        for (j = target; j >= 0; --j) {
            if (dp[n][j] && dp[n][j / 2]) return j / 2;
        }
        return -1;
    }

}
