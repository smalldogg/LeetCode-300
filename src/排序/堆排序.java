package 排序;

public class 堆排序 {
    public void heapSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = (nums.length - 2) / 2; i >= 0; --i) {
            shifDown(nums, i);
        }
    }


    private void shifDown(int[] nums, int k) {
        int len = nums.length - 1;
        while (k < len) {
            int minIdx = k;
            int left = minIdx * 2 + 1;
            int right = left + 1;
            if (left < len && nums[left] < nums[minIdx]) {
                minIdx = left;
            }
            if (right < len && nums[right] < nums[minIdx]) {
                minIdx = right;
            }
            if (minIdx == k) {
                break;
            }
            int tmp = nums[minIdx];
            nums[minIdx] = nums[k];
            nums[k] = tmp;
            k = minIdx;
        }
    }
}
