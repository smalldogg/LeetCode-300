package 链表和数组;

public class 有序链表转换为二分查找树 {
    public TreeNode sortedListToBST(ListNode head) {
        int len = getListLength(head);

        ListNode[] nodes = new ListNode[len];
        int idx = 0;
        while (head != null) {
            nodes[idx++] = head;
            head = head.next;
        }
        return build(nodes, 0, len - 1);
    }


    private TreeNode build(ListNode[] nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nodes[mid].val);
        root.left = build(nodes, start, mid - 1);
        root.right = build(nodes, mid + 1, end);
        return root;
    }

    private int getListLength(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
