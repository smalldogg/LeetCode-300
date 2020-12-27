package 链表和数组;

public class 链表划分 {
		public ListNode partition( ListNode head, int x ) {
				if( head == null ) {
						return head;
				}
				//链表划分的题目，记得将链表的下一个节点置为空
				ListNode dummyLess = new ListNode( 0 );
				ListNode dummyMore = new ListNode( 0 );
				ListNode nless = dummyLess;
				ListNode nMore = dummyMore;
				while( head != null ) {
						if( head.val < x ) {
								nless.next = head;
								nless = nless.next;
						} else {
								nMore.next = head;
								nMore = nMore.next;
						}
						head = head.next;
				}
				nMore.next = null;
				nless.next = dummyMore.next;
				return dummyLess.next;
		}
}
