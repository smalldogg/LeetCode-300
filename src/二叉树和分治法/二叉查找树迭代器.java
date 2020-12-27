package 二叉树和分治法;

import java.util.Stack;

public class 二叉查找树迭代器 {
		private Stack<TreeNode> stack = new Stack<>( );

		public 二叉查找树迭代器( TreeNode node ) {
				while( node != null ) {
						stack.push( node );
						node = node.left;
				}
		}

		public boolean hasNext( ) {
				return stack.isEmpty( );
		}

		public TreeNode next( ) {
				TreeNode curt = stack.peek( );
				TreeNode node = curt;
				if( node.right == null ) {
						node = stack.pop( );
						while( !stack.isEmpty( ) && stack.peek( ).right == node ) {
								node = stack.pop( );
						}
				} else {
						node = node.right;
						while( node != null ) {
								stack.push( node );
								node = node.left;
						}
				}
				return curt;
		}

}
