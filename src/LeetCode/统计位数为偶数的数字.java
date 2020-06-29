package LeetCode;

/**
 * @author wangyh
 * @create 2019-12-22 10:32
 */

public class 统计位数为偶数的数字 {



    public  int findNumbers(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (isOdd(nums[i])) {
                result++;
            }
        }
        return result;
    }

    private  boolean isOdd(int num) {
        int cnt = 0;
        while (num != 0) {
            cnt++;
            num /= 10;
        }
        return cnt % 2 == 0 ? true : false;
    }
}
