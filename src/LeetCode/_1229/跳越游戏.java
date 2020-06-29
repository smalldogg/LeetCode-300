package LeetCode._1229;

/**
 * @author wangyh
 * @create 2019-12-29 10:45
 */

public class 跳越游戏 {
    private int[] arr;
    private int len;
    private boolean[] visited;

    private boolean backTrack(int from) {
        if (from < 0 || from >= len || visited[from]) {
            return false;
        }

        if (arr[from] == 0) {
            return true;
        }

        visited[from] = true;
        return backTrack(from + arr[from])
                || backTrack(from - arr[from]);
    }

    public boolean canReach(int[] arr, int start) {
        this.arr = arr;
        len = arr.length;
        visited = new boolean[len];
        return backTrack(start);
    }
}
