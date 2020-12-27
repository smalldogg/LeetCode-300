package 二叉树和分治法;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyh on 2019/5/31.
 */
public class 二叉树的路径和II {

		//找到和为目标值的所有路径
		//任意节点开始，任意节点结束

		public List<List<Integer>> binaryTreePathSum2( TreeNode root, int target ) {
				List<List<Integer>> results = new ArrayList<List<Integer>>( );
				ArrayList<Integer> list = new ArrayList<Integer>( );
				if( root == null )
						return results;
				dfs( root, target, list, 0, results );
				return results;
		}

		private void dfs( TreeNode node, int sum, ArrayList<Integer> list, int level, List<List<Integer>> results ) {
				if( node == null ) {
						return;
				}
				int target = sum;
				list.add( node.val );
				for( int i = level; i >= 0; i-- ) {
						target -= list.get( i );
						if( target == 0 ) {
								List<Integer> cur = new ArrayList<>( );
								for( int j = i; j <= level; j++ ) {
										cur.add( list.get( j ) );
								}
								results.add( cur );
						}
				}
				dfs( node.left, sum, list, level + 1, results );
				dfs( node.right, sum, list, level + 1, results );
				list.remove( list.size( ) - 1 );
		}
}
