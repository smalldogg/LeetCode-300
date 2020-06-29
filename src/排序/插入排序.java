package 排序;

public class 插入排序 {
    public void insertSort1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                swap(nums, j, j + 1);
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void insertSort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int k = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > k) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = k;
        }
    }


    public void insertSort3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int t = nums[i];
            int j = i - 1;
            for (; j >= 0 && nums[j] > t; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = t;
        }
    }

}
