package 链表和数组;

/**
 * @author wangyh
 * @create 2020-02-12 18:55
 */

public class 删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = pre.next;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
            if (pre.next != cur) pre.next = cur.next; //说明有重复
            else pre = pre.next;
            cur = pre.next;
        }
        return dummy.next;
    }
}
