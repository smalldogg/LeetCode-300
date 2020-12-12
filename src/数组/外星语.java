package 数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyh
 * @create 2020-09-25 21:37
 */

public class 外星语 {
    public static void main(String[] args) {
        System.out.println(4 % 5);
    }

    public static boolean isAlienSorted(String[] words, String order) {
        char[] chs = order.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); ++i) map.put(chs[i], i + 1);
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            for (int j = 0; j < word.length() - 1; ++j) {
                int idx1 = map.get(word.charAt(j));
                int idx2 = map.get(word.charAt(j + 1));
                if (idx1 > idx2) return false;
            }
        }
        return true;
    }
}
