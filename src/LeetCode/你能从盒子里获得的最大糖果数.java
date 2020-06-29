package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author wangyh
 * @create 2019-12-23 20:17
 */

public class 你能从盒子里获得的最大糖果数 {
    public int maxCandies(int[] status, int[] candies,
                          int[][] keys, int[][] containedBoxes,
                          int[] initialBoxes) {
        int len = status.length;
        boolean[] v = new boolean[len];
        Set<Integer> havaBoxs = new HashSet<>();
        Set<Integer> haveKeys = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;

        //init
        for (int i = 0; i < initialBoxes.length; ++i) {
            int idx = initialBoxes[i];
            havaBoxs.add(idx);
            if (status[idx] == 1) {
                queue.offer(idx);
                v[idx] = true;
            }
        }

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            ans += candies[cur];
            int[] curKeys = keys[cur];
            int[] curBox = containedBoxes[cur];
            //遍历钥匙
            for (int key : curKeys) {
                haveKeys.add(key);
                if (!v[key] && havaBoxs.contains(key)) {
                    queue.offer(key);
                    v[key] = true;
                }
            }

            for (int box : curBox) {
                havaBoxs.add(box);
                if (!v[box] && (haveKeys.contains(box) || status[box] == 1)) {
                    queue.offer(box);
                    v[box] = true;
                }
            }
        }
        return ans;
    }
}
