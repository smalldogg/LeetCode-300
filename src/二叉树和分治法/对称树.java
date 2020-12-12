package 二叉树和分治法;

/**
 * Created by wyh on 2019/6/1.
 */
public class 对称树 {

		public static boolean isSymmetric( TreeNode root ) {
				if( root == null )
						return true;
				return dfs( root.right, root.left );
		}

		private static boolean help( TreeNode s, TreeNode t ) {
				if( s != null && t != null )
						return s.val == t.val && help( s.left, t.right ) && help( s.right, t.left );
				return s == null && t == null;
		}

		private static boolean dfs( TreeNode t, TreeNode s ) {
				if( t == null || s == null )
						return false;
				if( t == null && s == null )
						return true;
				return s.val == t.val && dfs( t.left, s.right ) && dfs( t.right, s.left );
		}
}
