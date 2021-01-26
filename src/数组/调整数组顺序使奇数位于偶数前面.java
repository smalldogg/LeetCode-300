package 数组;

/**
 * @author wangyh
 * @create 2021-01-26 18:09
 */

public class 调整数组顺序使奇数位于偶数前面 {
		public int[] exchange(int[] nums) {
				if (nums == null) return nums;
				int lIdx = 0, rIdx = nums.length - 1;
				while (lIdx < rIdx) {
						while (lIdx < rIdx && nums[lIdx] % 2 != 0) lIdx++;
						while (lIdx < rIdx && nums[rIdx] % 2 == 0) rIdx--;
						if (lIdx < rIdx) {
								swap(nums, lIdx, rIdx);
								lIdx++;
								rIdx--;
						}
				}
				return nums;
		}

		private void swap(int[] nums, int i, int j) {
				int t = nums[i];
				nums[i] = nums[j];
				nums[j] = t;
		}
}
