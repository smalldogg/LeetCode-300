package 排序;

import sun.awt.windows.ThemeReader;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * @author wangyh
 * @create 2020-03-23 22:25
 */

public class MyLock {

		private volatile int state;
		private Thread lockHolder;


		private ConcurrentLinkedQueue<Thread> waiters = new ConcurrentLinkedQueue<>( );

		public final boolean compareAndSwapState( int except, int update ) {
				return unsafe.compareAndSwapInt( this, stateOffset, except, update );
		}

		private static final Unsafe unsafe = UnsafeInsatance.reflectGetUnsafe( ); //如何获取unsafe实列对象

		Field singleoneInstanceField;

		private static long stateOffset;

		static {
				try {
						stateOffset = unsafe.objectFieldOffset( MyLock.class.getDeclaredField( "state" ) );
				} catch( NoSuchFieldException e ) {
						throw new Error( );
				}
		}

		private int getState( ) {
				return state;
		}

		private void setLockHolder( Thread thread ) {
				this.lockHolder = thread;
		}

		private boolean aquire( ) {
				Thread current = Thread.currentThread( );
				int state = getState( );
				if( state == 0 ) {
						//怎么获取锁
						//1.同步器还没有被持有
						//2.队列中的第一个
						if( ( waiters.size( ) == 0 || current == waiters.peek( ) ) && compareAndSwapState( 0, state ) ) {
								setLockHolder( current );
								return true;
						}
				}
				return false;
		}

		public void lock( ) {
				if( aquire( ) ) {
						return;
				}
				Thread current = Thread.currentThread( );
				waiters.add( current );
				for( ; ; ) {
						//让出cpu的使用权
						if( current == waiters.peek( ) && aquire( ) ) {
								waiters.poll( );
								return;
						}
						LockSupport.park( current );
				}
		}

		public void unlock( ) {
				if( Thread.currentThread( ) != lockHolder ) {
						throw new RuntimeException( "lockHolder is not current lock" );
				}
				int state = getState( );
				if( compareAndSwapState( state, 0 ) ) {
						setLockHolder( null );
						Thread first = waiters.peek( );
						if( first != null ) {
								//第一个重新抢夺cpu的使用权
								LockSupport.unpark( first );
						}
				}
		}


		public int maxProfit( int[] prices ) {
				if( prices.length < 2 ) {
						return 0;
				}
				int maxProfit = 0;
				int buy = prices[0];
				for( int i = 1; i < prices.length; ++i ) {
						if( buy > prices[i] ) {
								buy = prices[i];
						} else {
								maxProfit = Math.max( maxProfit, prices[i] - buy );
						}
				}
				return maxProfit;
		}
}
