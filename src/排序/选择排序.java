package 排序;

public class 选择排序 {
    public void selectSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                minIndex = nums[j] < nums[minIndex] ? j : minIndex;
            }
            swap(nums, i, minIndex);
        }
    }


    public void selectSort2(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int i = 0; i < nums.length; ++i) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIdx] < nums[j])
                    minIdx = j;
            }
            swap(nums, i, minIdx);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
