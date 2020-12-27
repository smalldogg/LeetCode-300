package 数组;

/**
 * @author wangyh
 * @create 2020-09-25 21:13
 */

public class 质数个数 {
		public int countPrimeSetBits( int L, int R ) {
				int count = 0;
				for( int i = L; i <= R; ++i ) {
						int one = getCount( i );
						if( isPrime( one ) )
								count++;
				}
				return count;
		}


		private int getCount( int num ) {
				int count = 0;
				while( num != 0 ) {
						count++;
						num &= ( num - 1 );
				}
				return count;
		}


		private boolean isPrime( int num ) {
				if( num == 1 )
						return false;
				if( num == 2 )
						return true;
				for( int i = 2; i <= Math.sqrt( num ); ++i ) {
						if( num % i == 0 )
								return false;
				}
				return true;
		}
}
