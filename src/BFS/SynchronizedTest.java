package BFS;

import java.util.Random;

/**
 * @author wangyh
 * @create 2020-05-15 8:38
 */
class MyThread implements Runnable {

		public int total;

		public int count;

		public MyThread( ) {
				total = 100;
				count = 0;
		}

		@Override public void run( ) {
				synchronized( this ) {
						if( total > 0 ) {
								try {
										Thread.sleep( new Random( ).nextInt( 1000 ) );
								} catch( InterruptedException e ) {
										e.printStackTrace( );
								}
								count++;
								total--;
								System.out.println( Thread.currentThread( ).getName( ) + "\t当前票号：" + count );
						}
				}
		}
}


public class SynchronizedTest {
		public static void main( String[] args ) {
				MyThread t = new MyThread( );
				for( int i = 1; i <= 3; i++ ) {
						new Thread( t, "售票点" + i ).start( );
				}


		}

}
