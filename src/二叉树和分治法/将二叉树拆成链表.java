package 二叉树和分治法;

/**
 * Created by wyh on 2019/5/31.
 */
public class 将二叉树拆成链表 {

		private TreeNode prev = null;

		//从下往上依次变遍历
		//1.递归的定义：将二叉树拆成链表
		public void flatten( TreeNode root ) {
				//3.递归的出口
				if( root == null ) {
						return;
				}
				//2.递归的拆解
				flatten( root.right );
				flatten( root.left );

				//本层应该做什么
				root.left = null;
				root.right = prev;
				prev = root;
		}
}
