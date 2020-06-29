package 链表和数组;

public class 翻转链表2 {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return dummy.next;
            }
            head = head.next;
        }
        ListNode fPre = head;
        ListNode mNode = head.next;
        ListNode pre = mNode;
        ListNode cur = mNode.next;
        ListNode next = null;
        for (int i = m; i < n; i++) {
            if (cur == null) {
                return dummy.next;
            }
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        mNode.next = cur;
        fPre.next = pre;
        return dummy.next;
    }
}
