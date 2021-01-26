package 数组;

public class 合并排序数组2 {
		public int[] mergeSortedArray( int[] A, int[] B ) {
				int len = A.length + B.length;
				int[] res = new int[len];
				int idx1 = 0, idx2 = 0, idx = 0;
				while( idx1 < A.length && idx2 < B.length ) {
						if( A[idx1] < B[idx2] ) {
								res[idx++] = A[idx1++];
						} else {
								res[idx++] = B[idx2++];
						}
				}
				while( idx1 < A.length ) {
						res[idx++] = A[idx1++];
				}
				while( idx2 < B.length ) {
						res[idx++] = B[idx2++];
				}
				return res;
		}
}
