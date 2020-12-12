package 二叉树和分治法;

/**
 * Created by wyh on 2019/5/31.
 */
public class 将二叉树转换成双链表 {


    public class DoublyListNode {
        int val;
        DoublyListNode next, prev;

        DoublyListNode(int val) {
            this.val = val;
            this.next = this.prev = null;
        }
    }


    public class ReturnType {
        public DoublyListNode start;
        public DoublyListNode end;

        public ReturnType(DoublyListNode start, DoublyListNode end) {
            this.start = start;
            this.end = end;
        }
    }

    private DoublyListNode dummy = new DoublyListNode(0);
    private DoublyListNode prev = dummy;

    public DoublyListNode bstToDoublyList(TreeNode root) {

        process2(root);
        return dummy.next;
    }

    private void process2(TreeNode node) {
        if (node == null) {
            return;
        }
        process2(node.left);
        DoublyListNode cur = new DoublyListNode(node.val);
        prev.next = cur;
        cur.prev = prev;
        prev = cur;
        process2(node.right);
    }


    private DoublyListNode process(TreeNode node) {
        if (node == null) {
            return null;
        }

        DoublyListNode left = process(node.left);
        DoublyListNode mid = new DoublyListNode(node.val);
        DoublyListNode right = process(node.right);

        if (right != null) {
            mid.next = right;
            right.prev = mid;
        }

        if (left != null) {
            DoublyListNode temp = left;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = mid;
            mid.prev = temp;
            mid = left;

        }
        return mid;
    }
}
