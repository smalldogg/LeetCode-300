package 二分;

/**
 * Created by wyh on 2019/5/30.
 */
public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int M = matrix.length, N = matrix[0].length;
        int col = matrix[0].length - 1, row = 0;
        while (col >= 0 && row < M) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }
}
