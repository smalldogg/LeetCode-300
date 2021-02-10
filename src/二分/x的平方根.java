package 二分;

/**
 * Created by wyh on 2019/5/30.
 */
public class x的平方根 {
    public int sqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x <= 0) {
            return x;
        }
        int start = 1, end = x;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end > x / end) {
            return start;
        }
        return end;
    }
}