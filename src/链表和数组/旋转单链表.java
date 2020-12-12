package 链表和数组;

/**
 * @author wangyh
 * @create 2020-02-13 16:48
 */

public class 旋转单链表 {
    public ListNode rotateRightToLeft(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        ListNode end = head;
        int n = 1;
        for (; end.next != null; end = end.next) n++;
        end.next = head;
        k %= n;
        ListNode newEnd = head;
        for (int i = 0; i < n - k - 1; ++i) newEnd = newEnd.next;
        ListNode newHead = newEnd.next;
        newEnd.next = null;
        return newHead;
    }
}
