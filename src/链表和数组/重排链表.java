package 链表和数组;

public class 重排链表 {
		public void reorderList( ListNode head ) {
				if( head == null || head.next == null ) {
						return;
				}
				ListNode mid = getMid( head );
				ListNode right = reverse( mid.next );
				mid.next = null;
				merge( head, right );
		}

		private ListNode getMid( ListNode head ) {
				ListNode slow = head;
				ListNode fast = head.next;
				while( fast != null && fast.next != null ) {
						fast = fast.next.next;
						slow = slow.next;
				}
				return slow;
		}

		private ListNode reverse( ListNode head ) {
				ListNode pre = null;
				ListNode next = null;
				while( head != null ) {
						next = head.next;
						head.next = pre;
						pre = head;
						head = next;
				}
				return pre;
		}

		private void merge( ListNode head1, ListNode head2 ) {
				ListNode dummy = new ListNode( 0 );
				int index = 0;
				while( head1 != null && head2 != null ) {
						if( index % 2 == 0 ) {
								dummy.next = head1;
								head1 = head1.next;
						} else {
								dummy.next = head2;
								head2 = head2.next;
						}
						index++;
						dummy = dummy.next;
				}
				if( head1 != null ) {
						dummy.next = head1;
				}
				if( head2 != null ) {
						dummy.next = head2;
				}
		}
}
