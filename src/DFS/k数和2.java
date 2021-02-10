package DFS;

import java.util.ArrayList;
import java.util.List;

public class k数和2 {
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(A, 0, k, target, list, results);
        return results;
    }

    private void dfs(int[] nums, int index, int k, int target, List<Integer> list, List<List<Integer>> results) {
        if (k == 0 && target == 0) {
            results.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || index >= nums.length)
            return;

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, k - 1, target - nums[i], list, results);
            list.remove(list.size() - 1);
        }
    }

    private void dfs2(int[] nums, int index, int k, int target, List<Integer> list, List<List<Integer>> results) {
        if (k == 0 && target == 0) {
            results.add(new ArrayList<>(list));
            return;
        }
        if (k < 0 || target < 0 || index >= nums.length)
            return;

        list.add(nums[index]);
        dfs2(nums, index + 1, k - 1, target - nums[index], list, results);
        list.remove(list.size() - 1);
        dfs2(nums, index + 1, k, target, list, results);
    }
}
