package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wyh on 2019/6/2.
 */
public class 课程表 {
    // 要学习课程 0 你需要先学习课程 1   [0,1]
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] in = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());


        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            ++in[pre[0]];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0)
                queue.offer(i);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int v = queue.poll();
            for (int next : graph.get(v)) {
                --in[next];
                if (in[next] == 0)
                    queue.offer(in[next]);
            }
        }
        return cnt == numCourses;
    }
}
