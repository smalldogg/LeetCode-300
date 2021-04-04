package 链表和数组;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 数组交集 {

    static List<Integer> union(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        if (list1 == null || list2 == null || list1.size() == 0 || list2.size() == 0) return result;
        List list = null;
        list = list1.size() > list2.size() ? list1 : list2;
        List<Integer> findList = list == list1 ? list2 : list1;
        Set<Integer> set = new HashSet<>(list);
        for (int i = 0; i < findList.size(); ++i) {
            if (set.contains(findList.get(i))) result.add(findList.get(i));
        }
        return result;
    }

}
