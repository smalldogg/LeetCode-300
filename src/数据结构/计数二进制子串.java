package 数据结构;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyh
 * @create 2020-08-10 22:47
 */

public class 计数二进制子串 {
    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        char[] chs = s.toCharArray();
        int ptr = 0, n = chs.length;
        while (ptr < n) {
            char c = chs[ptr];
            int count = 0;
            while (ptr < n && chs[ptr] == c) {
                ++ptr;
                ++count;
            }
            list.add(count);
        }
        int result = 0;
        for (int i = 1; i < list.size(); ++i)
            result = Math.min(list.get(i), list.get(i - 1));
        return result;
    }
}
