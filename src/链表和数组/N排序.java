package 链表和数组;

import java.util.stream.Stream;

public class N排序 {

    public static void mysort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                // 交换
                int t = nums[i] - 1;
                nums[i] = nums[nums[i] - 1];
                nums[t] = t + 1;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            System.out.println(nums[i]);
        }
    }
}
