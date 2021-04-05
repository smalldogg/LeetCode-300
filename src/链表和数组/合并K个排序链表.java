package 链表和数组;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 合并K个排序链表 {

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l1 != null) p.next = l2;
        return dummy.next;
    }

    public ListNode mergeKSortedListsOneByOne(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode result = null;
        for (int i = 0; i < lists.length; ++i) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add(5, "5");
    }

}
