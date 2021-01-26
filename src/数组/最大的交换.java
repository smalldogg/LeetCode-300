package 数组;

public class 最大的交换 {
		public int maximumSwap( int num ) {
				char[] digits = Integer.toString( num ).toCharArray( );

				int[] buckets = new int[10];
				for( int i = 0; i < digits.length; i++ ) {
						buckets[digits[i] - '0'] = i;
				}

				for( int i = 0; i < digits.length; i++ ) {
						for( int k = 9; k > digits[i] - '0'; k-- ) {
								if( buckets[k] > i ) {
										char tmp = digits[i];
										digits[i] = digits[buckets[k]];
										digits[buckets[k]] = tmp;
										return Integer.valueOf( new String( digits ) );
								}
						}
				}

				return num;
		}


		public static int maximumSwap2( int num ) {
				int[] digit = new int[9];
				int d = 0;
				while( num > 0 ) {
						digit[d] = num % 10;
						num = num / 10;
						d++;
				}
				num = 0;
				for( int i = d - 1; i > 0; i-- ) {//从最高位开始,
						// 对于每一位尝试从低位起寻找一个在它右边的最大的数, 若能找到, 直接交换即可.
						int max = i, j = 0;
						while( j < i ) {
								max = digit[j] > digit[max] ? j : max;
								j++;
						}
						if( max != i ) {
								int temp = digit[i];
								digit[i] = digit[max];
								digit[max] = temp;
								break;
						}
				}
				for( int i = d - 1; i >= 0; i-- ) {
						num = num * 10 + digit[i];
				}
				return num;
		}
}
