package 排序;

public class 第k大元素 {
    public int kthLargestElement(int n, int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return getKmax(nums, n, 0, nums.length - 1);
    }

    private int getKmax(int[] nums, int k, int start, int end) {
        int pivot = nums[(start + end) / 2];
        int i = start, j = end;
        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if (start + k - 1 <= j) {
            return getKmax(nums, k, start, j);
        }
        if (start + k - 1 >= i) {
            return getKmax(nums, k - (i - start), i, end);
        }
        return nums[j + 1];
    }
}
