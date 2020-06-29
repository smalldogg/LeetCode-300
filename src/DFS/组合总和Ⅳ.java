package DFS;

/**
 * @author wangyh
 * @create 2020-06-28 13:31
 */

public class 组合总和Ⅳ {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int j = 0; j < nums.length; ++j)
                if (nums[j] <= i) dp[i] += dp[i - nums[j]];
        }
        return dp[target];
    }
}
