package 二叉树和分治法;

/**
 * @author wangyh
 * @create 2020-02-28 14:28
 */
class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node( ) {
		}

		public Node( int _val ) {
				val = _val;
		}

		public Node( int _val, Node _left, Node _right, Node _next ) {
				val = _val;
				left = _left;
				right = _right;
				next = _next;
		}
};


public class 填充每个节点的下一个右侧节点指针 {
		public Node concet( Node node ) {
				if( node == null )
						return node;
				Node left = node.left;
				Node right = node.right;
				while( left != null ) {
						left.next = right;
						left = left.right;
						right = right.left;
				}
				concet( node.left );
				concet( node.right );
				return node;
		}

}
