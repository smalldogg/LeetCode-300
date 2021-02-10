package 双指针;

/**
 * @author wangyh
 * @create 2020-06-20 21:39
 */

public class 整数反转 {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + res % 10;
            res /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
        }
        return (int) res;
    }
}
