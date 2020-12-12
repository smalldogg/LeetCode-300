package 剑指Offer;

/**
 * @author wangyh
 * @create 2020-02-13 11:42
 */

public class 打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int counter = (int) Math.pow(10, n);
        int[] res = new int[counter - 1];
        for (int i = 1; i < counter; i++) res[i - 1] = i;
        return res;
    }
}
