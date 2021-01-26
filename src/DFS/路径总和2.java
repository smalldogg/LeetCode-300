package DFS;

import java.util.ArrayList;
import java.util.List;

public class 路径总和2 {
		public List<List<Integer>> pathSum( TreeNode root, int sum ) {
				List<List<Integer>> results = new ArrayList<>( );
				ArrayList<Integer> list = new ArrayList<Integer>( );
				if( root == null ) {
						return results;
				}
				list.add( root.val );
				findSum( results, list, root, sum - root.val );
				return results;
		}

		private void findSum( List<List<Integer>> results, List<Integer> list, TreeNode root, int sum ) {
				if( root.right == null && root.left == null ) {
						if( sum == 0 ) {
								results.add( new ArrayList<>( list ) );
						}
						return;
				}
				if( sum < 0 ) {
						return;
				}
				if( root.left != null ) {
						list.add( root.left.val );
						findSum( results, list, root.left, sum - root.left.val );
						list.remove( list.size( ) - 1 );
				}
				if( root.right != null ) {
						list.add( root.right.val );
						findSum( results, list, root.right, sum - root.right.val );
						list.remove( list.size( ) - 1 );
				}
		}
}
