package 双指针;

public class 移动零 {


    public  String move(String str) {
        char[] chs = str.toCharArray();
        int l = 0;
        int r = 0;
        while (r < chs.length) {
            if (chs[r] != '#') {
                char temp = chs[r];
                chs[r] = chs[l];
                chs[l] = temp;
                l++;
            }
            r++;
        }
        return new String(chs);
    }


    //将0移动到数组的最后 (相对顺序不变)
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public void moveZeroes2(int[] nums) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[l++] = nums[i];
            }
        }
        for (int i = l; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
