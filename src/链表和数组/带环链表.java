package 链表和数组;

public class 带环链表 {
		public boolean hasCycle( ListNode head ) {
				if( head == null || head.next == null ) {
						return false;
				}
				ListNode slow, fast;
				slow = head;
				fast = head.next;
				while( fast != slow ) {
						if( fast == null || fast.next == null ) {
								return false;
						}
						fast = fast.next.next;
						slow = slow.next;
				}
				return true;
		}
}
