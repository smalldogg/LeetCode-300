package 排序;

public class 快速排序 {

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }




    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int leftIndex = start;
        int mid = (start + end) / 2;
        int rightIndex = end;
        int pivot = nums[mid];
        while (leftIndex <= rightIndex) {
            //等于的两边都去
            while (leftIndex <= rightIndex && nums[leftIndex] < pivot) {
                leftIndex++;
            }
            while (leftIndex <= rightIndex && nums[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                int tmp = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = tmp;
                leftIndex++;
                rightIndex--;
            }
        }
        quickSort(nums, start, rightIndex);
        quickSort(nums, leftIndex, end);
    }
}
