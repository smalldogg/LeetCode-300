package 双指针;

import java.util.PriorityQueue;

/**
 * @author wangyh
 * @create 2020-02-08 19:51
 */

public class 数据流中位数 {
    public int[] medianII(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int n = nums.length;
        int[] result = new int[n];
        result[0] = nums[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> {
            return b - a;
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        maxHeap.add(nums[0]);
        for (int i = 1; i < n; ++i) {
            int cur = maxHeap.peek();
            if (cur <= nums[i]) {
                minHeap.add(nums[i]);
            } else {
                maxHeap.add(nums[i]);
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            result[i] = maxHeap.peek();
        }
        return result;
    }
}
