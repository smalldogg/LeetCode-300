package 链表和数组;

public class 两两交换链表中的节点 {
		public ListNode swapPairs( ListNode head ) {
				if( head == null || head.next == null ) {
						return head;
				}
				ListNode dummy = new ListNode( 0 );
				dummy.next = head;
				ListNode cur = dummy;
				while( cur.next != null && cur.next.next != null ) {
						ListNode node1 = cur.next;
						ListNode node2 = node1.next;
						ListNode next = node2.next;
						//交换两个节点

						node2.next = node1;
						node1.next = next;
						cur.next = node1;

						cur = node1;
				}
				return dummy.next;
		}
}
