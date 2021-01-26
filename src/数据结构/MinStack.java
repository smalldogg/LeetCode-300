package 数据结构;

import java.util.Stack;

/**
 * Created by wyh on 2019/5/31.
 */
public class MinStack {
		private Stack<Integer> dataStack;
		private Stack<Integer> minStack;

		public MinStack( ) {
				// do intialization if necessary
				dataStack = new Stack<>( );
				minStack = new Stack<>( );
		}

		public void push( int number ) {
				// write your code here
				if( minStack.isEmpty( ) ) {
						minStack.push( number );
				} else if( number < min( ) ) {
						minStack.push( number );
				} else {
						int newMIn = minStack.peek( );
						minStack.push( newMIn );
				}
				dataStack.push( number );
		}

		public int pop( ) {
				// write your code here
				int value = dataStack.pop( );
				minStack.pop( );
				return value;
		}

		public int min( ) {
				// write your code here
				return minStack.peek( );
		}

}
