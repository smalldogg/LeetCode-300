package 数组;

import java.util.Stack;

/**
 * @author wangyh
 * @create 2020-02-28 10:55
 */

public class 最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int max = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            max = Math.max(max, largestRectangleAreaStack(heights));
        }

        return max;
    }

    public int largestRectangleAreaStack(int[] heights) {
        int max = 0, n = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < n; ++i) {
            while (stack.peek() != -1 &&
                    heights[stack.peek()] >= heights[i]) {
                int heigh = heights[stack.pop()];
                max = Math.max(max, heigh * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int heigh = heights[stack.pop()];
            max = Math.max(max, heigh * (n - stack.peek() - 1));
        }
        return max;
    }

}
