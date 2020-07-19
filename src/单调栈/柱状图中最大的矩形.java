package 单调栈;


import java.util.Stack;

/**
 * @author wangyh
 * @create 2020-07-11 10:00
 */

public class 柱状图中最大的矩形 {
    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            int h = heights[i], j = i, w = 1;
            while (--j >= 0 && heights[j] >= h) {
                w++;
            }
            j = i;
            while (++j < heights.length && heights[j] >= h) {
                w++;
            }
            max = Math.max(max, w * h);
        }
        return max;
    }


    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; ++i) {

        }
        return max;
    }
}
