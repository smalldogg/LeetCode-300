package 排序;

import java.util.stream.Stream;

/**
 * @author wangyh
 * @create 2020-06-29 20:40
 */

public class 数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        return quickSort(nums, 0, nums.length - 1, k);
    }

    public int quickSort(int[] nums, int start, int end, int k) {
        int i = start, j = end;
        int pivot = nums[(start + end) / 2];
        while (i <= j) {
            while (i <= j && nums[i] > pivot) i++;
            while (i <= j && nums[j] < pivot) j--;
            if (i <= j) {
                //swap
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
        }
        if (j - start + 1 >= k) {
            return quickSort(nums, start, j, k);
        }
        if (i - start + 1 <= k) {
            return quickSort(nums, i, end, k - (i - start));
        }
        return nums[j + 1];
    }
}
