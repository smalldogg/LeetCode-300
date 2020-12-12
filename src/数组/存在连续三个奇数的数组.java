package 数组;

/**
 * @author wangyh
 * @create 2020-11-19 18:14
 */

public class 存在连续三个奇数的数组 {

		public boolean threeConsecutiveOdds(int[] arr) {
				if(arr == null || arr.length == 0)
						return false;
				boolean result = false;
				for(int i = 1; i < arr.length - 1; ++i) {
						if(arr[i - 1] % 2 != 0 && arr[i] % 2 != 0 && arr[i + 1] % 2 != 0)
								return true;
				}
				return result;
		}
}
