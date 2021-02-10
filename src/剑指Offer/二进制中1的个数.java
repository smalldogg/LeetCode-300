package 剑指Offer;

/**
 * @author wangyh
 * @create 2020-02-13 11:13
 */

public class 二进制中1的个数 {
    public int hammingWeight1(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }
}
