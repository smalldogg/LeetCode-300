package 排序;

/**
 * @author wangyh
 * @create 2020-06-29 20:40
 */

public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        return quickSort(nums,0, nums.length - 1, k);
    }

    public int quickSort(int[] num, int start, int end, int k) {

    }
}
