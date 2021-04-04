package 数组;

public class 最长回文 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); ++i) {
            int len1 = help(s, i, i);
            int len2 = help(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int help(String s, int l, int r) {
        char[] chs = s.toCharArray();
        while (l >= 0 && r <= chs.length - 1 && chs[l] == chs[r]) {
            l--;
            r++;
        }
        return r - l + 1;
    }

}
