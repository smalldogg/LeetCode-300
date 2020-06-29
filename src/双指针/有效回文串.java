package 双指针;

public class 有效回文串 {
    //刚才没有考虑数字的情况
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] chs = s.toCharArray();
        int l = 0, r = chs.length - 1;
        while (l < r) {
            while (l < r && !isvalid(chs[l])) {
                l++;
            }
            while (l < r && !isvalid(chs[r])) {
                r--;
            }
            if (Character.toLowerCase(chs[l]) != Character.toLowerCase(chs[r])) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    public boolean isvalid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
