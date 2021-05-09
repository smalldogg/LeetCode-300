package 前缀和;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangyh
 * @create 2020-03-01 10:02
 */

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        String s = set.stream().collect(Collectors.joining(","));
        System.out.println(s);
    }

}
