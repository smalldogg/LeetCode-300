package 二分;

/**
 * Created by wyh on 2019/5/30.
 */
public class 对x开根II {
    public double sqrt(double x) {
        double start = 0;
        double end = Math.max(x, 1.0);
        double eps = 1e-12;
        while (start + eps < end) {
            double mid = (start + end) / 2;
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
