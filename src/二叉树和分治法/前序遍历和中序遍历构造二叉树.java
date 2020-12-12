package 二叉树和分治法;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wyh on 2019/6/1.
 */
public class 前序遍历和中序遍历构造二叉树 {
		public TreeNode buildTree( int[] preorder, int[] inorder ) {
				HashMap<Integer, Integer> inMap = new HashMap<>( );
				for( int i = 0; i < inorder.length; i++ ) {
						inMap.put( inorder[i], i );
				}
				return build( preorder, 0, preorder.length - 1, 0, inMap );
		}

		private TreeNode build( int[] pre, int start, int end, int inStart, HashMap<Integer, Integer> inMap ) {
				if( start > end ) {
						return null;
				}
				TreeNode root = new TreeNode( pre[start] );
				int rootIdx = inMap.get( pre[start] );
				int leftLen = rootIdx - inStart;
				root.left = build( pre, start + 1, start + leftLen, inStart, inMap );
				root.right = build( pre, start + leftLen + 1, end, rootIdx + 1, inMap );
				return root;
		}

}
