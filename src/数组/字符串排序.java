package 数组;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyh
 * @create 2021-02-24 10:18
 */

public class 字符串排序 {
    public void sortChar(String str) {
        if (str == null || str.length() == 0) return;
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; ++i) {
            map.put(chs[i], map.getOrDefault(chs[i], 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            return o2.getValue() - o1.getValue();
        });
    }
}
