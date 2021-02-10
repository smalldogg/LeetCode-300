package 双指针;

/**
 * @author wangyh
 * @create 2020-03-06 10:59
 */

public class 字符串查找 {
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); ++j) {
                if (source.charAt(i + j) != source.charAt(j))
                    break;
            }
            if (j == target.length())
                return i;
        }
        return -1;
    }

}
