package LeetCode._1229;

/**
 * @author wangyh
 * @create 2019-12-29 10:34
 */

public class 和为零的N个唯一整数 {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        if (n == 1) {
            result[0] = 1;
            return result;
        }
        int next = n;
        if (n % 2 == 0) {
            for (int i = 0; i < n; ++i) {
                if (i > 1 && i % 2 == 0) {
                    next = Math.abs(next);
                    next--;
                }
                result[i] = next;
                next = -next;
            }
        } else {
            result[0] = 0;
            for (int i = 1; i < n; ++i) {
                if (i > 1 && i % 2 != 0) {
                    next = Math.abs(next);
                    next--;
                }
                result[i] = next;
                next = -next;
            }
        }
        return result;
    }

    public int[] sumZero2(int n) {
        int[] ans = new int[n];
        int index = 0;
        for (int i = 1; i <= n / 2; i++) {
            ans[index++] = -i;
            ans[index++] = i;
        }
        return ans;

    }
}
