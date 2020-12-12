package 双指针;

public class 字符大小写排序 {
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        int l = 0, r = chars.length - 1;
        while (l <= r) {
            while (l <= r && chars[l]>= 'a' && chars[l] <= 'z') {
                l++;
            }
            while (l <= r && chars[r] >= 'A' && chars[r] <= 'Z') {
                r--;
            }
            if (l < r) {
                char c = chars[l];
                chars[l] = chars[r];
                chars[r] = c;
                l++;
                r--;
            }
        }
    }
}
