package LeetCode._0105;

/**
 * @author wangyh
 * @create 2020-01-05 12:59
 */

public class 前缀异或和 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xors = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; ++i) {
            xors[i] = xors[i - 1] ^ arr[i - 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            ans[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        }
        return ans;
    }
}
