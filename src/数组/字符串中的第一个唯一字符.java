package 数组;

/**
 * @author wangyh
 * @create 2020-03-04 22:05
 */

public class 字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return -1;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i)
            cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); ++i) {
            if (cnt[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
