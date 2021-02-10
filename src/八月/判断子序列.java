package 八月;

/**
 * @author wangyh
 * @create 2020-08-29 22:49
 */

public class 判断子序列 {
    /**
     * 判断字符串s是否为t的子序列
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        if (s.length() > t.length())
            return false;
        int idx = 0;
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        for (int i = 0; i < cht.length; ++i) {
            if (idx == chs.length)
                return true;
            if (chs[idx] == cht[i])
                idx++;
        }
        return idx == chs.length;
    }
}
