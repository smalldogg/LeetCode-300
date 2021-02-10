package 双指针;

/**
 * @author wangyh
 * @create 2020-02-07 17:57
 */

public class 最多有k个不同字符的最长子字符串 {

    public int lengthOfLongestSubstringKDistinct(String ss, int k) {
        int max = Integer.MIN_VALUE;
        char[] s = ss.toCharArray();
        int[] map = new int[256];
        int count = 0;
        for (int l = 0, r = 0; r < s.length; ++r) {
            map[s[r]]++;
            if (map[s[r]] == 1)
                count++;
            while (count > k) {
                map[s[l]]--;
                if (map[s[l]] == 0)
                    count--;
                l++;

            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
