package 双指针;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wangyh
 * @create 2020-02-08 19:49
 */

public class 滑动窗口的中位数 {
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int curMedian;
        if (k > 1) {
            maxHeap.add(nums[0]);
            for (int i = 1; i < k - 1; ++i) {
                int x = maxHeap.peek();
                if (nums[i] <= x) {
                    maxHeap.add(nums[i]);
                } else {
                    minHeap.add(nums[i]);
                }
            }
            curMedian = maxHeap.peek();
        } else {
            curMedian = 0;
        }
        for (int i = k - 1; i < nums.length; ++i) {
            if (nums[i] <= curMedian) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
            while (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            curMedian = maxHeap.peek();
            result.add(curMedian);
            if (nums[i - k + 1] <= curMedian) {
                maxHeap.remove(nums[i - k + 1]);
            } else {
                minHeap.remove(nums[i - k + 1]);
            }
        }
        return result;
    }
}
