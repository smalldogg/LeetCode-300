package 数据结构;

import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int value = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; ++i) {
            if (i == chs.length - 1) {
                value += map.get(chs[i]);
            } else {
                int left = map.get(chs[i]);
                int right = map.get(chs[i + 1]);
                if (left >= right) {
                    value += left;
                } else {
                    value -= left;
                }
            }
        }
        return value;
    }
}
