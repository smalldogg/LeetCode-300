package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 带重复元素的排列 {
    //找出所有不同的排列
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {

            return results;
        }
        List<Integer> list = new ArrayList<>();
        boolean[] v = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, v, list, results);
        return results;
    }

    private void dfs(int[] nums, boolean[] v, List<Integer> list,
                     List<List<Integer>> results) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<>(list));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (v[i]) {
                continue;
            }
            if (i != 0 && nums[i] == nums[i - 1] && !v[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            v[i] = true;

            dfs(nums, v, list, results);

            list.remove(list.size() - 1);
            v[i] = false;
        }
    }

}