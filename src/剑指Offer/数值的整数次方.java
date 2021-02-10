package 剑指Offer;

/**
 * @author wangyh
 * @create 2020-02-13 11:19
 */

public class 数值的整数次方 {
    public double myPow(double x, int n) {
        double result = 1;
        long N = Math.abs((long) n);
        for (int i = 0; i < N; ++i) {
            result = result * x;
        }
        return n < 0 ? 1 / result : result;
    }

    public double myPow2(double x, int n) {
        double result = 1;
        long N = Math.abs((long) n);
        while (N != 0) {
            if ((N & 1) == 1)
                result *= x;
            x *= x;
            N >>= 1;
        }
        return n < 0 ? 1 / result : result;
    }
}
