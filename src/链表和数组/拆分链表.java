package 链表和数组;

/**
 * @author wangyh
 * @create 2021-01-18 17:35
 */

public class 拆分链表 {


    public static ListNode reverse(ListNode head) {
        if (head == null)
            return head;
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


    public static ListNode splitAndMerge(ListNode head) {
        ListNode list1 = new ListNode(0), list2 = new ListNode(0);
        ListNode dummy = new ListNode(0);
        ListNode last = dummy, list1Head = list1, list2Head = list2;  //list2Head是降序
        int i = 0;
        while (head != null) {
            if (i % 2 != 0) {
                list1.next = head;
                list1 = list1.next;
            } else {
                list2.next = head;
                list2 = list2.next;
            }
            ++i;
            head = head.next;
        }
        list1.next = null;
        list2.next = null;
        list2Head = reverse(list2Head.next);
        list1Head = list1Head.next;
        while (list1Head != null && list2Head != null) {
            if (list1Head.val < list2Head.val) {
                last.next = list1Head;
                list1Head = list1Head.next;
            } else {
                last.next = list2Head;
                list2Head = list2Head.next;
            }
            last = last.next;
        }
        if (list1Head != null) {
            last.next = list1Head;
        }
        if (list2Head != null) {
            last.next = list2Head;
        }
        return dummy.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(8);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(4);
        ListNode listNode = splitAndMerge(head);
        print(listNode);
    }
}
