package 链表和数组;

public class MergeMyList {


    public ListNode mergeSortedList(ListNode head) {
        ListNode[] listNodes = splitList(head);
        listNodes[1] = reverseList(listNodes[1]);
        ListNode result = mergeList(listNodes[0], listNodes[1]);
        return result;
    }

    /**
     * 将链表按奇偶位置拆成两个链表
     * @param head
     * @return 返回一个长度为2的数组
     */
    private ListNode[] splitList(ListNode head) {
        if (head == null) return new ListNode[]{};
        ListNode[] result = new ListNode[2];
        int idx = 0;
        ListNode l1 = new ListNode(0), l2 = new ListNode(0);
        ListNode cur1 = l1, cur2 = l2;
        while (head != null) {
            if (idx % 2 == 0) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            idx++;
            head = head.next;
        }
        cur1.next = null;
        cur2.next = null;;
        result[1] = l2.next;
        result[0] = l1.next;
        return result;
    }


    /**
     * 合并两个排序链表
     * @param l1
     * @param l2
     * @return 返回合并后的链表
     */
    private ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }


    /**
     * 将链表反转
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
