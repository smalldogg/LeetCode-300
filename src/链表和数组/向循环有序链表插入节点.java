package 链表和数组;

public class 向循环有序链表插入节点 {
    public ListNode insert(ListNode node, int x) {
        ListNode newNode = new ListNode(x);
        if (node == null) {
            newNode.next = newNode;
            return newNode;
        }
        ListNode pre = node;
        ListNode cur = node.next;
        while (cur != node) {
            if (pre.val <= x && cur.val >= x) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = newNode;
        newNode.next = cur;
        return node.val < x ? node : newNode;
    }
}

