package 链表和数组;

public class 删除排序链表中的重复元素_递归 {
		public ListNode deleteDuplicates( ListNode head ) {
				//递归的终止条件
				if( head == null || head.next == null ) {
						return head;
				}
				//返回值  返回已经去重重复元素的链表
				head.next = deleteDuplicates( head.next );

				//本层递归的任务
				if( head.val == head.next.val ) {
						head = head.next;
				}
				return head;
		}
}
