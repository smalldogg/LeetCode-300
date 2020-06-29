package 二分;

/**
 * Created by wyh on 2019/5/30.
 */
public class 颜色分类 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        partition(nums);
    }


    private void partition(int[] nums) {
        int less = -1;
        int more = nums.length;
        int index = 0;
        while (index < more) {
            if (nums[index] == 0) {
                swap(nums, ++less, index++);
            } else if (nums[index] == 2) {
                swap(nums, --more, index);
            } else {
                index++;
            }
        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
