package DFS;

/**
 * @author wangyh
 * @create 2020-07-27 9:15
 */

public class 判断子序列 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (s.length() > t.length()) return false;
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int i = 0, j = 0;
        while (j < cht.length && i < chs.length) {
            if (chs[i] == cht[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == chs.length;
    }
}
