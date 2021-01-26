package 二叉树和分治法;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wyh on 2019/5/31.
 */
public class 二叉树后序遍历 {
		public List<Integer> postorderTraversal( TreeNode root ) {
				List<Integer> result = new ArrayList<>( );
				if( root == null ) {
						return result;
				}
				Stack<TreeNode> s1 = new Stack<>( );
				Stack<TreeNode> s2 = new Stack<>( );
				s1.push( root );
				while( !s1.isEmpty( ) ) {
						TreeNode node = s1.pop( );
						s2.push( node );
						if( node.left != null ) {
								s1.push( node.left );
						}
						if( node.right != null ) {
								s1.push( node.right );
						}
				}
				while( !s2.isEmpty( ) ) {
						result.add( s2.pop( ).val );
				}
				return result;
		}
}
