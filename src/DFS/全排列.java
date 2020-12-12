package DFS;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        boolean[] v = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(nums, list, v, results);
        return results;
    }

    private void dfs(int[] nums, List<Integer> list, boolean[] v,
                     List<List<Integer>> results) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<>(list));
            return;
        }

        //枚举每一个位置
        for (int i = 0; i < nums.length; i++) {
            if (v[i]) {
                continue;
            }
            list.add(nums[i]);
            v[i] = true;

            dfs(nums, list, v, results);

            list.remove(list.size() - 1);
            v[i] = false;
        }
    }
}
