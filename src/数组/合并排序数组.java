package 数组;

public class 合并排序数组 {
		public void mergeSortedArray( int[] A, int m, int[] B, int n ) {
				int idx1 = m - 1;
				int idx2 = n - 1;
				int idx = m + n - 1;
				while( idx1 >= 0 && idx2 >= 0 ) {
						if( A[idx1] > B[idx2] ) {
								A[idx--] = A[idx1--];
						} else {
								A[idx--] = B[idx2--];
						}
				}
				while( idx1 >= 0 ) {
						A[idx--] = A[idx1--];
				}
				while( idx2 >= 0 ) {
						A[idx--] = B[idx2--];
				}
		}
}
