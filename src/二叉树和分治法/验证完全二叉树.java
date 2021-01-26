package 二叉树和分治法;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wyh on 2019/6/1.
 */
public class 验证完全二叉树 {
		public boolean isFullTree( TreeNode root ) {
				Queue<TreeNode> queue = new LinkedList<>( );
				boolean leaf = false;
				TreeNode r = null, l = null;
				queue.offer( root );
				while( !queue.isEmpty( ) ) {
						root = queue.poll( );
						l = root.left;
						r = root.right;
						//不是完全二叉树的情况
						//1. 有右无左
						//2. 如果这个节点是叶子结点，那么往后的节点都是叶子节点
						if( r != null && l == null || ( leaf && ( r != null || l != null ) ) ) {
								return false;
						}
						if( l != null ) {
								queue.offer( l );
						}
						if( r != null ) {
								queue.offer( r );
						} else {
								leaf = true;
						}
				}
				return true;
		}
}
