package 二叉树和分治法;

/**
 * Created by wyh on 2019/5/31.
 */
public class 平衡二叉树 {
		//需要返回得信息超过1个时，要使用ReturnType;


		public class ReturnType {
				public boolean isB;
				public int height;

				public ReturnType( boolean isB, int height ) {
						this.isB = isB;
						this.height = height;
				}
		}

		public boolean isBalanced( TreeNode root ) {
				return help( root ).isB;
		}

		//1.递归的定义：判断二叉树是否平衡
		private ReturnType help( TreeNode node ) {
				//3.递归的出口  结束条件
				if( node == null ) {
						return new ReturnType( true, 0 );
				}
				//2.递归的拆解   应该给上一级返回什么信息
				ReturnType left = help( node.left );
				ReturnType right = help( node.right );

				if( !left.isB || !right.isB ) {
						return new ReturnType( false, -1 );
				}
				if( Math.abs( left.height - right.height ) > 1 ) {
						return new ReturnType( false, -1 );
				}

				//本层应该做什么
				return new ReturnType( true, Math.max( left.height, right.height ) + 1 );
		}

}
