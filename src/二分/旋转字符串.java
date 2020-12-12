package 二分;

/**
 * Created by wyh on 2019/5/30.
 */
public class 旋转字符串 {
    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0)
            return;
        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }
    private void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
