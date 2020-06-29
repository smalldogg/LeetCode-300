package 数据结构;

public class 堆化 {
    private void shifDown(int[] nums, int k) {
        int n = nums.length;
        while (k < n) {
            int minIdx = k;
            int left = minIdx * 2 + 1;
            int right = left + 1;
            if (left < n && nums[left] < nums[minIdx]) {
                minIdx = left;
            }
            if (right < n && nums[right] < nums[minIdx]) {
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

    public void heapify(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        for (int i = (A.length - 2) / 2; i >= 0; i--) {
            shifDown(A,i);
        }
    }
}
