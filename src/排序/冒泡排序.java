package 排序;

public class 冒泡排序 {
    public void bubbleSort(int[] nums){
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int e = nums.length - 1; e > 0; e--) {
            for (int j = 0; j < e; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums,j, j + 1);
                }
            }
        }

    }
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
