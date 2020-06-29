package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangyh
 * @create 2019-12-22 10:56
 */

public class 子串的最大出现次数 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char[] chars = s.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length - minSize; ++i) {
            if (getCounts(chars, i, i + minSize - 1) <= maxLetters) {
                String key = String.valueOf(chars, i, minSize);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        int max = 0;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }
        return max;
    }


    private int getCounts(char[] chars, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; ++i) {
            set.add(chars[i]);
        }
        return set.size();
    }
}
